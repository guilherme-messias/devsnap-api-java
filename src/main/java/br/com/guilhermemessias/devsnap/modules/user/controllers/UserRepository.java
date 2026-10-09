package br.com.guilhermemessias.devsnap.modules.user.controllers;

import br.com.guilhermemessias.devsnap.modules.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserDetails findByUsername(String username);
    Optional<UserEntity> findById(String id);
}
