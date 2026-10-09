package br.com.guilhermemessias.devsnap.config;

import br.com.guilhermemessias.devsnap.modules.user.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generateToken(UserEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            LocalDateTime now = LocalDateTime.now().plusHours(1);

            return JWT.create()
                    .withIssuer("devsnap")
                    .withSubject(user.getId())
                    .withExpiresAt(now.toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String searchUserToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");

            return JWT.require(algorithm)
                    .withIssuer("devsnap")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Error searching user token", e);
        }
    }
}
