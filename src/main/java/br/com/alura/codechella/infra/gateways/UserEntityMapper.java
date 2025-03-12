package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.controller.UserDto;
import br.com.alura.codechella.infra.persistence.UserEntity;

public class UserEntityMapper {
    public UserEntity fromDomainToEntity(User user) {
        return new UserEntity(
                user.getCpf(),
                user.getName(),
                user.getBirthDate(),
                user.getEmail()
        );
    }

    public User fromEntityToDomain(UserEntity user){
        return new User(
                user.getCpf(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate()
        );
    }

    public User fromDtoToDomain(UserDto user){
        return new User(
                user.cpf(),
                user.name(),
                user.email(),
                user.birthDate()
        );
    }

    public UserDto fromDomainToDto(User user){
        return new UserDto(
                user.getCpf(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate()
        );
    }
}
