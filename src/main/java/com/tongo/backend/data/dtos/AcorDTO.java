package com.tongo.backend.data.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AcorDTO {
    private String fName;
    private String lName;
    private Date dOb;
    private String bio;

    public AcorDTO (String name, String lname, Date dOb, String bio){
        this.fName = name;
        this.lName = lname;
        this.dOb = dOb;
        this.bio = bio;
    }
}
