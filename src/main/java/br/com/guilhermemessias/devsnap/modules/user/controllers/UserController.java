package br.com.guilhermemessias.devsnap.modules.user.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserDTO> createUser (@Valid @RequestBody CreateUserDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        CreateUserDTO createUserDTO = userService.createUser(dto);
        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(createUserDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(createUserDTO);
    }

}
