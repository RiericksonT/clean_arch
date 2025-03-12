package br.com.alura.codechella.aplication.usecases;

import br.com.alura.codechella.aplication.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;


public class CreateUser {
    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        return userRepository.registerUser(user);
    }

}
