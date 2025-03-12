package br.com.alura.codechella.aplication.usecases;

import br.com.alura.codechella.aplication.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public class GetAllUsers {
    private final UserRepository userRepository;

    public GetAllUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers(){
        return userRepository.listAllUsers();
    }
}
