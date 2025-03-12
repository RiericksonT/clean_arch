package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.aplication.gateways.UserRepository;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.infra.persistence.UserRepositoryImpJPA;

import java.util.List;
import java.util.Objects;

public class UserRepositoryJPA implements UserRepository {
    private final UserRepositoryImpJPA repository;
    private final UserEntityMapper mapper;

    public UserRepositoryJPA(UserRepositoryImpJPA repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User registerUser(User user) {
        return mapper.fromEntityToDomain(repository.save(mapper.fromDomainToEntity(user)));
    }

    @Override
    public List<User> listAllUsers() {
        List<UserEntity> users = repository.findAll();
        return users.stream()
                .map(mapper::fromEntityToDomain)
                .toList();
    }

    @Override
    public User getUserByCpf(String cpf) {
        try {
            return getUserByCpf(cpf);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User updateUser(String cpf, User user) {
        UserEntity findUser = repository.findByCpf(cpf);
        if (findUser != null) {
            UserEntity updatedUser = mapper.fromDomainToEntity(user);
            updatedUser.setId(findUser.getId());
            repository.save(updatedUser);
            return mapper.fromEntityToDomain(updatedUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUserByCpf(String cpf) {
        UserEntity user = repository.findByCpf(cpf);
        if (Objects.nonNull(user)) {
            repository.deleteById(user.getId());
        }
    }
}
