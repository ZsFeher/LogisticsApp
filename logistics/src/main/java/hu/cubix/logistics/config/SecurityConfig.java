package hu.cubix.logistics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import hu.cubix.logistics.security.JwtAuthFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(){
		User.UserBuilder users = User.builder();
		UserDetails addressmanager = users
				.username("addressmanager")
				.password(passwordEncoder().encode("pass"))
				.authorities("addressmanager")
				.build();
		UserDetails transportmanager = users
				.username("transportplanmanager")
				.password(passwordEncoder().encode("pass"))
				.authorities("transportplanmanager")
				.build();

		return new InMemoryUserDetailsManager(addressmanager,transportmanager);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(
						csrf -> csrf.disable()
				)
				.authorizeHttpRequests(auth ->
						auth
								.requestMatchers(HttpMethod.POST, "/api/login").permitAll()
								.requestMatchers( HttpMethod.POST, "/api/addresses/**").hasAuthority("addressmanager")
								.requestMatchers( HttpMethod.PUT, "/api/addresses/**").hasAuthority("addressmanager")
								.requestMatchers("/api/addresses/**").authenticated()
								.requestMatchers("/api/sections/**").authenticated()
								.requestMatchers("/api/milestones/**").authenticated()
								.requestMatchers( "/api/transportPlans/**").hasAuthority("transportplanmanager")
				)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
