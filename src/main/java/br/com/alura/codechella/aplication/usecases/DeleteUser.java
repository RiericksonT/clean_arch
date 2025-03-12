package br.com.alura.codechella.aplication.usecases;

import br.com.alura.codechella.aplication.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

public class DeleteUser {
    private final UserRepository userRepository;

    public DeleteUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(String cpf){
        userRepository.deleteUserByCpf(cpf);
    }
}
