package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class UserDto {
    private int id;
    private String name;
    private String surname;
    private int shiftNumber;
    private String birthDay;
}
