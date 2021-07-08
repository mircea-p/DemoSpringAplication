package com.sda.demo.mvc.repository;

import com.sda.demo.mvc.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserRepositoryIF extends CrudRepository<User, Integer> {
  Integer deleteByUsername(String username);
  List<User> getAllByAgeBetween(Integer minAge, Integer maxAge);
}
