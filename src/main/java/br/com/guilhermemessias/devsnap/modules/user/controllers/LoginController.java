package br.com.guilhermemessias.devsnap.modules.user.controllers;

import br.com.guilhermemessias.devsnap.config.TokenService;
import br.com.guilhermemessias.devsnap.modules.user.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid CredentialsUserDTO credentialsUser) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentialsUser.getUsername(),
                credentialsUser.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return ResponseEntity.ok(tokenService.generateToken((UserEntity) authentication.getPrincipal()));
    }
}
