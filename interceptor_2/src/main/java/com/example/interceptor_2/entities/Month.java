package com.example.interceptor_2.entities;

import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
public class Month {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

}