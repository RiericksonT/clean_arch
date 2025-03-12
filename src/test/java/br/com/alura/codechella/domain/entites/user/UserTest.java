package br.com.alura.codechella.domain.entites.user;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.domain.entities.user.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class UserTest {

    private User validUser;

    @BeforeEach
    public void setup() {
        validUser = new User("123.456.789-00", "Jack", "jack@gmail.com", LocalDate.parse("1990-09-08"));
    }

    @Test
    public void dontCreateUserWithCpfInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User(null, validUser.getName(), validUser.getEmail(), validUser.getBirthDate()));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("12345679800", validUser.getName(), validUser.getEmail(), validUser.getBirthDate()));
    }

    @Test
    public void dontCreateUserWithEmailInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User(validUser.getCpf(), validUser.getName(), "jack@com", validUser.getBirthDate()));
    }

    @Test
    public void dontCreateUserWithBirthDateInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User(validUser.getCpf(), validUser.getName(), validUser.getEmail(), LocalDate.now()));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User(validUser.getCpf(), validUser.getName(), validUser.getEmail(), LocalDate.now().minusYears(17)));
    }

    @Test
    public void createUserWithFactory() {
        UserFactory factory = new UserFactory();
        User user = factory.UserWithoutAddress(validUser.getCpf(), validUser.getName(), validUser.getEmail(), validUser.getBirthDate());
        Assertions.assertNotNull(user);

        user = factory.UserWithAddress("Rua 1", "123", "Apto 1", "12345-678");
        Assertions.assertEquals("Rua 1", user.getAddress().getStreet());
    }
}
