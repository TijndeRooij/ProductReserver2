package com.reserver.ProductReserver.Users;

import com.reserver.ProductReserver.API.Enums.Enum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    private User User(){
        User newUser = new User();
        newUser.setUserName("TestUser");
        newUser.setFirstName("Test");
        newUser.setLastName("Van Jansen");
        newUser.setPassword("0f2OOG");
        newUser.setPhoneNumber(0633556723L);
        newUser.setEmail("TestUser@hotmail.com");
        newUser.setRole(Enum.userRole.admin);
        newUser.setBirthday(LocalDate.now());
        return newUser;
    }

    @Test
    public void testCreateUser() {
        User user = User();

        User savedUser = userRepo.save(user);

        User exitUser = entityManager.find(User.class, savedUser.getId());
        assertThat(user.getEmail()).isEqualTo(exitUser.getEmail());
    }
}

