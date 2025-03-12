package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.domain.entities.user.User;

public class UserUpdateDTO {
    private String cpf;
    private User user;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
