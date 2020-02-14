package com.tongo.backend.data.dtos;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortPlayDTO {

    private String playName;
    private Date premierDate;

}
