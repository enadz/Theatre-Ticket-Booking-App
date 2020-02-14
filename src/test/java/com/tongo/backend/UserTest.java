package com.tongo.backend;
import com.tongo.backend.data.models.Actors;
import com.tongo.backend.data.models.User;
import com.tongo.backend.repositories.PlayRepository;
import com.tongo.backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {
    @MockBean
    private UserRepository userRepository;
    
    @Test
    void userTest(){
        Date dob0  = new Date(23/01/1990);
        Date dob1  = new Date(05/01/1993);
        Date dob2  = new Date(14/11/2001);


        User user0 = new User("Jane",  "Doe", 50.5, 0, dob0, "066066066");
        User user1 = new User("Jon",  "Doe", 10.0, 0, dob1, "033555666");
        List<User> users= new ArrayList<>();
        users.add(user0); users.add(user1);


        User userTest=new User("Jill",  "Dio", 22.0, 4, dob2, "061111222");

        userTest.setId(8);
        Optional<User> userPresent= userRepository.findById(8);
        assert(userPresent.get().getFirstName()).equals(userTest.getFirstName());
    }

}


