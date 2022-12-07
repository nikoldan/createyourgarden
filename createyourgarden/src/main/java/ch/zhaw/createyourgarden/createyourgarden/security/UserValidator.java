package ch.zhaw.createyourgarden.createyourgarden.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

import ch.zhaw.createyourgarden.createyourgarden.model.Kunde;
import ch.zhaw.createyourgarden.createyourgarden.repository.KundeRepository;

class UserValidator implements OAuth2TokenValidator<Jwt> {

    KundeRepository kundeRepository;

    public UserValidator(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        OAuth2Error error = new OAuth2Error("invalid_token", "The required email is missing", null);

        String userEmail = jwt.getClaimAsString("email");
        if (userEmail != null && !userEmail.equals("")) {
            if (kundeRepository.findByEmail(userEmail).size() == 0) {
                String username = jwt.getClaimAsString("nickname");
                kundeRepository.save(new Kunde(username, userEmail));
            }
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(error);
    }
}