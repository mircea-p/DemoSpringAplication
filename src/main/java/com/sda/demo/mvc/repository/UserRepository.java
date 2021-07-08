package com.sda.demo.mvc.repository;

import com.sda.demo.mvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class UserRepository {

    public List<User> userList;
    @Autowired
    public UserRepository(List<User> userList) {

        this.userList = userList;
        User user1 = new User(1,"Paul", "paulica", "1234","paul@p.ro",32);
        User user2 = new User(2,"Andrei", "andrei", "1234","andrei@p.ro",37);
        User user3 = new User(3,"Vasile", "vasilica", "1234","vsile@p.ro",25);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
    //    // create, read, update, delete.
//
//    //create
//    public abstract void save(User user);
//
//
//    //read
//    public abstract User findUserByUsername(String userName);

    public  List<User> findAllUsers(){

        return userList;
    }

    public void addNewUser(User user){
        userList.add(user);

    }

    public User delete(int index){

        User deletedUser = userList.remove(index);
        log.info("Am sters userul: "+deletedUser.toString());
        return deletedUser;
    }
}
