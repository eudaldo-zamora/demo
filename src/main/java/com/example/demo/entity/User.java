package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "paske")
public class User {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "usuario")
    private String username;

    @Column(name = "clave")
    private String password;

}
