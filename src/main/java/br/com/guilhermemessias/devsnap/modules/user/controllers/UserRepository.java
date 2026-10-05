package br.com.guilhermemessias.devsnap.modules.user.controllers;

import br.com.guilhermemessias.devsnap.modules.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
