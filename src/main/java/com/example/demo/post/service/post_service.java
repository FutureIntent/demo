package com.example.demo.post.service;

import com.example.demo.post.model.Post;
import com.example.demo.post.repository.post_repository;
import com.example.demo.post.repository.show_posts;
import com.example.demo.post.request.patchPost_request;
import com.example.demo.post.response.creation_response;
import com.example.demo.post.response.showPosts_response;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.user_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class post_service {

    @Autowired
    user_repository userRepository;

    @Autowired
    post_repository postRepository;

    public ResponseEntity<creation_response> create_post(Post post, Principal principal){
        try{
            User user = userRepository.findByEmail(principal.getName());
            post.setUser(user);
            postRepository.save(post);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new creation_response(false, "Unable to create post"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new creation_response(true, "Post has been created"), HttpStatus.OK);
    }

    public ResponseEntity<showPosts_response> showPosts(Integer page, Integer size, String sortBy) {
        String message;
        try {
            Pageable paging = PageRequest.of(page, size, Sort.by(sortBy).descending());
            Page<show_posts> pagedResult = postRepository.showAllPosts(paging);

            Long totalItems = pagedResult.getTotalElements();
            List<show_posts> posts = pagedResult.getContent();
            Integer totalPages = pagedResult.getTotalPages();
            Integer currentPage = page + 1;

            if (pagedResult.hasContent()) {
                message = "Success";
                return new ResponseEntity<>(new showPosts_response(totalItems, posts, totalPages, currentPage, message), HttpStatus.OK);
            } else {
                message = "No content";
                return new ResponseEntity<>(new showPosts_response(totalItems, posts, totalPages, currentPage, message), HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            message = "Wrong query";
            return new ResponseEntity<>(new showPosts_response(0L, new ArrayList<>(), 0, 0, message), HttpStatus.BAD_REQUEST);
        }
        }

    public ResponseEntity<showPosts_response> userPosts(Integer page, Integer size, String sortBy, String email) {
        String message;
        try {
            Pageable paging = PageRequest.of(page, size, Sort.by(sortBy).descending());
            Page<show_posts> pagedResult = postRepository.showUserPosts(email, paging);

            Long totalItems = pagedResult.getTotalElements();
            List<show_posts> posts = pagedResult.getContent();
            Integer totalPages = pagedResult.getTotalPages();
            Integer currentPage = page + 1;

            if (pagedResult.hasContent()) {
                message = "Success";
                return new ResponseEntity<>(new showPosts_response(totalItems, posts, totalPages, currentPage, message), HttpStatus.OK);
            } else {
                message = "No content";
                return new ResponseEntity<>(new showPosts_response(totalItems, posts, totalPages, currentPage, message), HttpStatus.OK);
            }
        }catch(Exception e){
            message = "Wrong query";
            return new ResponseEntity<>(new showPosts_response(0L, new ArrayList<>(), 0, 0, message), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<creation_response> deletePosts (Principal principal, Long id){
        Integer deletion = 0;
    try{
        User user = userRepository.findByEmail(principal.getName());
        deletion = postRepository.deleteUserPost(id,user.getUser_id());
    }catch(Exception e){
        return new ResponseEntity<>(new creation_response(false, "Unable to delete post"), HttpStatus.BAD_REQUEST);
    }
       if(deletion < 1) return new ResponseEntity<>(new creation_response(true, "Nothing has been deleted"), HttpStatus.OK);

        return new ResponseEntity<>(new creation_response(true, "Post " + id + " has been deleted"), HttpStatus.OK);
    }

    public ResponseEntity<creation_response> patchPost(Principal principal, patchPost_request new_post){

        try{
           User user = userRepository.findByEmail(principal.getName());
           Post post = postRepository.findByPostIdAndUserId(new_post.getPost_id(), user.getUser_id());

           if(post == null)  return new ResponseEntity<>(new creation_response(false, "Unable to find post"), HttpStatus.BAD_REQUEST);

           if(new_post.getHeader() != null) post.setHeader(new_post.getHeader());

           if(new_post.getContent() != null) post.setContent(new_post.getContent());

           postRepository.save(post);

        }catch(Exception e){
            return new ResponseEntity<>(new creation_response(false, "Unable to update post"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new creation_response(true, "Post has been updated"), HttpStatus.ACCEPTED);
    }

}
