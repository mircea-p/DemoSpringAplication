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
    private String username;
    private String password;
    private String email;
    private int age;



}
