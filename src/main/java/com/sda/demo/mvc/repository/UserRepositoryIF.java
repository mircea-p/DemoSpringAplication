package com.sda.demo.mvc.repository;

import com.sda.demo.mvc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryIF extends CrudRepository<User, Integer> {
}
