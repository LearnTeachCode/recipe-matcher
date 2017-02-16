package devApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import devApp.entity.user.service.WebUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebUserService webUserService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // setting BCryptPasswordEncoder for Security Service
    	auth.userDetailsService(webUserService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		//.antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
        		.antMatchers("/").hasAnyAuthority("USER,ADMIN")		        
        		.antMatchers("/welcome").hasAnyAuthority("USER,ADMIN")	
                .antMatchers("/manage/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("USER,ADMIN")	
                .antMatchers("/recipes/**").hasAnyAuthority("USER,ADMIN")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .passwordParameter("password")
                    .usernameParameter("username")
                    .defaultSuccessUrl("/welcome")
                    .failureUrl("/login?error")
                    .permitAll()
                 .and()
                 .logout().logoutSuccessUrl("/login?logout");
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