package devApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import devApp.entity.user.service.WebUserService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebUserService webUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll(); // this will give all access to /login
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     /* auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
        auth
                .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER"); */
        auth.userDetailsService(
                this.getWebUserService());
        //.passwordEncoder(new BCryptPasswordEncoder());
    }

    public WebUserService getWebUserService() {
        return webUserService;
    }

    public void setWebUserService(WebUserService webUserService) {
        this.webUserService = webUserService;
    }
}