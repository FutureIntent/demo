package com.example.demo.user.repository;

import com.example.demo.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface user_repository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * from USER u where u.email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}
