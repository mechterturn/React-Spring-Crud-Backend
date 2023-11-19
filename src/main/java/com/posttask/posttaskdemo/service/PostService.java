package com.posttask.posttaskdemo.service;

import com.posttask.posttaskdemo.entity.Post;

import java.util.List;

public interface PostService {


    List<Post> findAll();

    Post findById(int theId);

    void save(Post thePost);

    void deleteById(int theId);

}
