package org.example;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    private String brithday;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String eMail;
    @Column(name = "walet")
    private int wallet;

}