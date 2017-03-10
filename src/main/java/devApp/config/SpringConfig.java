package devApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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

    /*
    @Bean
    @Autowired
    public WebUserDao getWebUserDao(SessionFactory sessionFactory) {
        return new WebUserDaoImpl(sessionFactory);
    }
	*/

    @Bean(name="appHelper")
    public AppHelper getAppHelper(){
    	return new AppHelper();
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean 
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
