package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int quantity;
    private LocalDate delivery;

}
