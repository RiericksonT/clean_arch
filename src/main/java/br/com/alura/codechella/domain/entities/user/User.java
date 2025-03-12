package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private UUID identifier;
    private String cpf;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Address address;

    public User(String cpf, String name, String email, LocalDate birthDate) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException(" Invalid CPF ");
        }

        if (email == null || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException(" Invalid Email ");
        }

        if (birthDate == null ||  LocalDate.now().getYear() - birthDate.getYear() < 18) {
            throw new IllegalArgumentException(" User must be over 18 years old ");
        }

        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
