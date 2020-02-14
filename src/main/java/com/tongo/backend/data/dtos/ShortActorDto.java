package com.tongo.backend.data.dtos;

import lombok.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ShortActorDto {
    private int id;
    private String name;
    private String lastName;

    public ShortActorDto (int Id, String Name, String LastName){
        this.id = Id;
        this.name = Name;
        this.lastName = LastName;
    }
}



