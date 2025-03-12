package br.com.alura.codechella.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryImpJPA extends JpaRepository<UserEntity, Long> {
    UserEntity findByCpf(String cpf);
}
