package com.Yixuan.springboot.myfirstwebapp.security;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	private static final String UserDetails = null;
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		String username = "yixuan";
		String password = "1234";
		UserDetails userDetails = createNewUser(username, password);
		UserDetails userDetails1 = createNewUser("ranga", "dummy");
		UserDetails userDetails2 = createNewUser("xingzhe", "1234");


		return new InMemoryUserDetailsManager(userDetails,userDetails1,userDetails2);
	}
	private UserDetails createNewUser(String username, String password) {
		Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder().
				passwordEncoder(passwordEncoder).
				username(username).
				password(password).
				roles("User","ADMIN").
				build();
		return userDetails;
	}
//	InMemoryUserDetailsManager(UserDetails)
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsecurity ) throws Exception {
		httpsecurity.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		httpsecurity.formLogin(withDefaults());
		httpsecurity.csrf().disable();
		httpsecurity.headers().frameOptions().disable();
		return httpsecurity.build();
	}
}
