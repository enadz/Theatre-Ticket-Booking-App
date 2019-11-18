package com.pozoriste.pozoristebackend.data.dtos;

import com.pozoriste.pozoristebackend.data.models.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;

    public UserDto (User user){
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
    }
}
