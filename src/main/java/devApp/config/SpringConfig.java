package devApp.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.dao.RecipeDaoImpl;
import devApp.entity.recipe.service.RecipeService;
import devApp.entity.recipe.service.RecipeServiceImpl;
import devApp.entity.user.dao.WebUserDao;
import devApp.entity.user.dao.WebUserDaoImpl;
import devApp.helpers.AppHelper;

@Configuration
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver(){
        final InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        final Integer defaultCachePeriod = 31556926;

        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/")
                .setCachePeriod(defaultCachePeriod);
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/img/")
                .setCachePeriod(defaultCachePeriod);
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/")
                .setCachePeriod(defaultCachePeriod);
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("/fonts/")
                .setCachePeriod(defaultCachePeriod);
    }

    @Bean
    @Autowired
    public WebUserDao getWebUserDao(SessionFactory sessionFactory) {
        return new WebUserDaoImpl(sessionFactory);
    }
    
    @Bean(name="recipeDao")
    public RecipeDao getRecipeDao(){
    	return new RecipeDaoImpl();
    }
    
    @Bean(name="recipeService")
    public RecipeService getRecipeService(){
    	return new RecipeServiceImpl();
    }

    @Bean(name="appHelper")
    public AppHelper getAppHelper(){
    	return new AppHelper();
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
