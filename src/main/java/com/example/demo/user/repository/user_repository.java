package com.example.demo.user.repository;

import com.example.demo.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Table;

@Repository
@Table(name = "user")
public interface user_repository extends PagingAndSortingRepository<User, Long> {
    @Query(value = "SELECT * from USER u where u.email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user u WHERE u.email = :email", nativeQuery = true)
    Integer deleteByEmail(@Param("email") String email);

    @Query(value = "SELECT * from user", nativeQuery = true)
    Page<show_user> showUsers(Pageable paging);
}
