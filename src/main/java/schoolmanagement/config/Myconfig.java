package schoolmanagement.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import schoolmanagement.services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class Myconfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService  customUserDetailsService;
	
	
	@Autowired
	private JWTAuthenticationfilter jwtfilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(customUserDetailsService);
		
	}
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()
		.cors()
		.disable()
		.authorizeRequests()
		.antMatchers("/token")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
		http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean 
	public PasswordEncoder passencoder()
	
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Bean
	public AuthenticationManager authenticationmanagerbean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	

}
