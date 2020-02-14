package com.tongo.backend.data.dtos;

import com.tongo.backend.data.models.User;
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
    private double balance;
    private String phonenum;

    public UserDto (User user){
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        balance =user.getBalance();
        phonenum=user.getPhonenum();
    }
}
