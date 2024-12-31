package com.gajula.security;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AadJwtDecoder implements JwtDecoder {

    private final static Logger admin = LogManager.getLogger(AadJwtDecoder.class);
	
    private NimbusJwtDecoder delegated;

    
    //@Value("${oauth2.issuers}")
    @Value("${train.resourceserver.aad.jwt.issuer-uri}")
    private String issuer;

    @Value("${train.resourceserver.aad.jwt.jwk-set-uri}")
    private String jwkSetUri;

    @Value("#{'${train.access.token.claim.allowed.audiences}'.replace(' ', '').split(',')}")
    private List<String> audiences;

    @PostConstruct
    public void init() {
        admin.info("initialize decoder");
        delegated = buildDecoder();
    }

    @Override
    public Jwt decode(String token) throws JwtException{
    	return delegated.decode(token);
    }

    private NimbusJwtDecoder buildDecoder() {
    	final NimbusJwtDecoder nimbusJwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
        try {
            admin.info("verify sugneture start");
    		nimbusJwtDecoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(
                    new JwtTimestampValidator(),
                    new JwtIssuerValidator(issuer),
                    new JwtAudienceValidator(audiences)
            ));
            admin.info("verify sugneture end");
            //return nimbusJwtDecoder;
    	}catch (Exception e) {
            admin.error("INVALID BEARER TOKEN 222222");
			//throw new RuntimeException("Invalid Bearer Token", e.getCause());
		}    	
        return nimbusJwtDecoder;
    }
}
