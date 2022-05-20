package com.example.demo.post.repository;

import com.example.demo.post.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Table;

@Table(name = "post")
@Repository
public interface post_repository extends PagingAndSortingRepository<Post, Long> {

@Query(value = "SELECT p.*, u.email from post p INNER JOIN user u ON p.user_id = u.user_id", countQuery = "SELECT COUNT(*) from post",
        nativeQuery = true)
Page<show_posts> showAllPosts(Pageable paging);

@Query(value = "SELECT p.*, u.email from post p INNER JOIN user u ON p.user_id = u.user_id WHERE u.email = :email",
        countQuery = "SELECT COUNT(*) from post p INNER JOIN user u ON p.user_id = u.user_id WHERE u.email = :email",
        nativeQuery = true)
Page<show_posts> showUserPosts(@Param("email") String email, Pageable paging);

@Transactional
@Modifying
@Query(value = "DELETE from post WHERE post.post_id = :id AND post.user_id = :user_id", nativeQuery = true)
Integer deleteUserPost(@Param("id") Long id, @Param("user_id") Long user_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE from post WHERE post.user_id = :user_id", nativeQuery = true)
    Integer deleteByUserId(@Param("user_id") Long user_id);
}
