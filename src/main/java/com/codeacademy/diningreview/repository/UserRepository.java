package com.codeacademy.diningreview.repository;

import java.util.Optional;

import com.codeacademy.diningreview.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  public Optional<User> findByName(String name);

  
}

/**
 * findById(Long id)
 * findAll()
 * save(User a) for creating & modifying
 * delete(User a)
 */