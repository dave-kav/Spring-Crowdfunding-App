package ie.cit.crowdfunding.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ie.cit.crowdfunding.entity.Project;
import ie.cit.crowdfunding.repository.ProjectRepository;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	@Autowired
	ProjectRepository projectRepository;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()       
                .antMatchers("/", "/projects", "/projects/*", "/css/**", "/js/**", "/less/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
							throws IOException, ServletException {
						Iterable<Project> projects = projectRepository.findAll();
						arg0.setAttribute("project_list", projects);
						arg1.sendRedirect("projects");
					}
				})
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth
    		.jdbcAuthentication()
    		.dataSource(dataSource);
    }
}