package br.com.alura.codechella.config;

import br.com.alura.codechella.aplication.gateways.UserRepository;
import br.com.alura.codechella.aplication.usecases.CreateUser;
import br.com.alura.codechella.aplication.usecases.DeleteUser;
import br.com.alura.codechella.aplication.usecases.GetAllUsers;
import br.com.alura.codechella.aplication.usecases.UpdateUser;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryJPA;
import br.com.alura.codechella.infra.persistence.UserRepositoryImpJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CreateUser createUser(UserRepository userRepository){
        return new CreateUser(userRepository);
    }

    @Bean
    GetAllUsers getAllUsers(UserRepository userRepository){
        return new GetAllUsers(userRepository);
    }

    @Bean
    DeleteUser deleteUser(UserRepository userRepository){
        return new DeleteUser(userRepository);
    }

    @Bean
    UpdateUser updateUser(UserRepository userRepository){
        return new UpdateUser(userRepository);
    }

    @Bean
    UserRepositoryJPA createUserRepositoryJPA(UserEntityMapper mapper, UserRepositoryImpJPA repository){
        return new UserRepositoryJPA( repository, mapper);
    }

    @Bean
    UserEntityMapper createUserEntityMapper(){
        return new UserEntityMapper();
    }
}
