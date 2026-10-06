package br.com.guilhermemessias.devsnap.modules.user.controllers;

import br.com.guilhermemessias.devsnap.modules.user.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor()
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public CreateUserDTO createUser(@Valid CreateUserDTO dto) {
        UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
        userRepository.save(userEntity);
        return modelMapper.map(userEntity, CreateUserDTO.class);
    }
}
