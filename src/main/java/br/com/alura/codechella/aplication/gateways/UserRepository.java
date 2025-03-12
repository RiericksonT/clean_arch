package br.com.alura.codechella.aplication.gateways;

import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public interface UserRepository {

    User registerUser(User user);
    List<User> listAllUsers();
    User getUserByCpf(String cpf);
    User updateUser(String cpf, User user);
    void deleteUserByCpf(String cpf);
}
