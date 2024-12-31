package com.gajula.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public class JwtAudienceValidator implements OAuth2TokenValidator<Jwt> {

	private final static Logger admin = LogManager.getLogger(JwtAudienceValidator.class);

    private static final OAuth2Error AUDIENCE_ERROR = new OAuth2Error(
            "invalid_request",
            "This aud claim is not equal to the configured audience",
            "https://tools.ietf.org/html/rfc6750#section-3.1"
    );

    private final List<String> allowedAudiences;

    public JwtAudienceValidator(List<String> allowedAudiences) {
        if (allowedAudiences.isEmpty()) {
            throw new IllegalArgumentException("Allowed audiences list can't be empty");
        }
        this.allowedAudiences = allowedAudiences;
    }

    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        List<String> audience = token.getAudience();
        boolean allowed = audience.stream()
                .anyMatch(allowedAudiences::contains);

        return allowed ? OAuth2TokenValidatorResult.success() : OAuth2TokenValidatorResult.failure(AUDIENCE_ERROR);
    }
}
