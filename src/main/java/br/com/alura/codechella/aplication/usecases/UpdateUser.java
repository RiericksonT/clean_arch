package br.com.alura.codechella.aplication.usecases;

import br.com.alura.codechella.aplication.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

public class UpdateUser {
    private final UserRepository userRepository;

    public UpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(String cpf, User user){
        return userRepository.updateUser(cpf ,user);
    }
}
