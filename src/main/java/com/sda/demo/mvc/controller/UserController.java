package com.sda.demo.mvc.controller;


import com.sda.demo.mvc.model.User;
import com.sda.demo.mvc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/cinema/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<String> findAllUsers(@RequestParam(value = "minAge", required = false) Integer a, @RequestParam(value = "maxAge", required = false) Integer b) {
        if ((a == null) || (b == null))
            return new ResponseEntity<>("NU sti ce vrei, apesi aiurea, trebuie sa dai varstele!!! ", HttpStatus.BAD_REQUEST);

        List<User> ageUsers = userService.findUsersInAgeGroup(a, b);
        log.info("Am trecut pe aici. Am gasit user-ii dupa varsta.");
        log.warn(ageUsers.toString());
        return new ResponseEntity<>(ageUsers.toString(), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {

        return "Hello!";
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // creaza un user nou // TODO Catch exception , delete mapping.

        try {
            userService.saveUser(user);
        } catch (Exception e) {
            log.info("Nu ati introdus date complete, va rugam sa reintroduceti datele complete:");
            return new ResponseEntity<>("Nu ati introdus date complete, va rugam sa reintroduceti datele complete:", HttpStatus.BAD_REQUEST);
        }

        log.info(user.toString());
        return new ResponseEntity<>("Am salvat un user nou: " + user.toString(), HttpStatus.CREATED);
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> deleteUser(@RequestParam String username) {
        User user = userService.deleteUser(username);
        return new ResponseEntity<String>("We deleted: " + user.toString(), HttpStatus.OK);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
