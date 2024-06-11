package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {
    private int id;
    private String productName;
    private int quantity;
    private LocalDate delivery;
}
