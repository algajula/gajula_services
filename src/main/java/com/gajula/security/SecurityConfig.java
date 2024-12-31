package com.gajula.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final static Logger admin = LogManager.getLogger(SecurityConfig.class);

	@Autowired
	private AadJwtDecoder aadJwtDecoder;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		admin.info("Configure---> Start");
		http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/swagger-ui.html","/swagger-ui/**", "/swagger-resources/**",
								"/webjars/**", "/v3/api-docs/**", "/h2-console/**",
								"/home/**", "/views/**",
								"/css/**", "/js/**", "/images/**",
								"/api/v1/templates/**", "/api/v1/master/**").permitAll()
						.requestMatchers("/api/v1/aws/s3/**", "/api/v1/book/**", "/api/v1/customer/**").authenticated()
				)
				.exceptionHandling(exp -> exp.authenticationEntryPoint(authenticationEntryPoint())
						                     .accessDeniedHandler(accessDeniedHandler()))
				.csrf(AbstractHttpConfigurer::disable)
				.cors(AbstractHttpConfigurer::disable)
				.httpBasic(AbstractHttpConfigurer::disable)
				.oauth2ResourceServer((oauth2) ->
						oauth2.jwt((jwt1) -> jwt1.decoder(jwtDecoder())
								.jwtAuthenticationConverter(jwt -> {
									try {
										if (null != jwt) {
											admin.info("jwt.getClaimAsString(\"email\") <><><><><><>:" + jwt.getClaimAsString("email"));
											final Collection<? extends GrantedAuthority> grantedAuthorities = Optional
													.ofNullable(jwt.getClaimAsStringList("roles"))
													.stream()
													.flatMap(Collection::stream)
													.map(SimpleGrantedAuthority::new)
													.collect(Collectors.toList());
											return new JwtAuthenticationToken(jwt, null, jwt.getClaimAsString("email"));
										}
									} catch (Exception e) {
										admin.error("error in beare token");
										throw new RuntimeException("error in beare token");
									}
									return null;
								})).authenticationEntryPoint(authenticationEntryPoint())
								.accessDeniedHandler(accessDeniedHandler())
				)
				.exceptionHandling(exp -> exp.authenticationEntryPoint(authenticationEntryPoint())
						.accessDeniedHandler(accessDeniedHandler()));

		//http.headers(header -> header.frameOptions(frame -> frame.disable()));
		admin.info("Configure---> End");
		return http.build();
	}

	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOriginPatterns("*")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}*/

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomeAuthenticationEntryPoint();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder
				.withJwkSetUri("https://login.microsoftonline.com/common/discovery/keys")
				.jwsAlgorithm(SignatureAlgorithm.RS256).build();
	}

}
