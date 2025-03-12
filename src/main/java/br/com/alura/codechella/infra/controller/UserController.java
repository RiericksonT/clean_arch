package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.aplication.usecases.CreateUser;
import br.com.alura.codechella.aplication.usecases.DeleteUser;
import br.com.alura.codechella.aplication.usecases.GetAllUsers;
import br.com.alura.codechella.aplication.usecases.UpdateUser;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final CreateUser createUser;
    private final GetAllUsers getAllUsers;
    private final DeleteUser deleteUser;
    private final UserEntityMapper mapper;
    private final UpdateUser updateUser;

    public UserController(CreateUser createUser, GetAllUsers getAllUsers, DeleteUser deleteUser, UserEntityMapper mapper, UpdateUser updateUser) {
        this.createUser = createUser;
        this.getAllUsers = getAllUsers;
        this.deleteUser = deleteUser;
        this.mapper = mapper;
        this.updateUser = updateUser;
    }

    @PostMapping
    public UserDto userRegister(@RequestBody UserDto dto){
        User saved = createUser.registerUser(mapper.fromDtoToDomain(dto));
        return mapper.fromDomainToDto(saved);
    }

    @GetMapping
    public List<UserDto> getUsers(){
        List<User> listUser = getAllUsers.listAllUsers();
        return listUser.stream().map(mapper::fromDomainToDto).toList();
    }

    @DeleteMapping
    public void deletUser(@RequestBody UserDto dto){
        deleteUser.deleteUser(dto.cpf());
    }

    @PutMapping
    public User updateUser(@RequestBody UserUpdateDTO dto){
        return updateUser.updateUser(dto.getCpf(), dto.getUser());
    }
}
