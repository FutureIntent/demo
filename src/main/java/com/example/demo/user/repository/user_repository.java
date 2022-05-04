package com.example.demo.user.repository;

import com.example.demo.user.model.myUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface user_repository extends PagingAndSortingRepository<myUser, Long> {
    @Query(value = "SELECT * from USER u where u.email = :email", nativeQuery = true)
    myUser findByEmail(@Param("email") String email);
}
