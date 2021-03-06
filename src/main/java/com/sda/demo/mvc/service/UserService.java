package com.sda.demo.mvc.service;

import com.sda.demo.mvc.model.User;
import com.sda.demo.mvc.repository.UserRepository;
import com.sda.demo.mvc.repository.UserRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    // all users with age between in a certain interval [x,y]
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepositoryIF userRepositoryIF;

    public List<User> findUsersInAgeGroup(int x, int y) {
//        List<User> allUsers = userRepository.findAllUsers();
//        // filter, map, collect.
//        return allUsers.stream()
//                .filter(user -> user.getAge() > x && user.getAge() < y)
//                .collect(Collectors.toList());
        return userRepositoryIF.getAllByAgeBetween(x,y);
    }

    public void saveUser(User user) {
     //   if (user.getName() != null && user.getAge() != 0 && user.getUsername() != null && user.getEmail() != null && user.getPassword() != null) {
            userRepositoryIF.save(user);
            log.info("Sefule, alo, am salvat un user nou!!!");

    }
    @Transactional
    public void deleteUser(String username) {
//        List<User> allUsers = userRepository.findAllUsers();
//        Integer i = null;
//        for (User user : allUsers) {
//            if (user.getUsername().equals(username))
//                i = allUsers.indexOf(user);
//        }
//        if (i != null) {
//            return userRepository.delete(i);
//        }
//        else
//            throw new IllegalArgumentException("Nu e cutarica, bre, (user not found)");

        Integer idUserDeleted = userRepositoryIF.deleteByUsername(username);
        if(idUserDeleted == 0)
            log.warn("User- ul nu exista, deci nu avem ce sterge.");
        else
            log.info("Am sters userul cu id - ul: " + idUserDeleted);

    }
    public User updateUser(User user){

        saveUser(user);
        return user;

    }


    }
