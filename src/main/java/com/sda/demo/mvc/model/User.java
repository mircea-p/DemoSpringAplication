package com.sda.demo.mvc.model;


import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    @NotNull(message = "Username can not be null")
    private String username;
    @NotNull(message = "Pasword can not be null")
    private String password;
    @Email
    private String email;

    private int age;



}
