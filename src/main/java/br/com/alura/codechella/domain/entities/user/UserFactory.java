package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

//Builder pattern

public class UserFactory {
    private User user;

    public User UserWithoutAddress(String cpf, String name, String email, LocalDate birthDate) {
        this.user = new User(cpf, name, email, birthDate);
        return this.user;
    }

    public User UserWithAddress(String street, String number, String complement, String zipCode) {
        this.user.setAddress(new Address(street, number, zipCode, complement));
        return this.user;
    }
}