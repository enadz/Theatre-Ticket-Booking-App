package com.tongo.backend.data.dtos;

import com.tongo.backend.data.models.Performance;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PlayDetailsSimpleDto {
    private int id;
    private String name;
    private String description;
    private String image;
    private List<Performance> performances;
    public PlayDetailsSimpleDto(int id, String name, String description, String image, List<Performance> performances){
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.performances = performances;
    }
}
