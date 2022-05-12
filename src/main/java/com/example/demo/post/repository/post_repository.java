package com.example.demo.post.repository;

import com.example.demo.post.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface post_repository extends PagingAndSortingRepository<Post, Long> {

}
