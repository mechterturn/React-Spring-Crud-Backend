package com.posttask.posttaskdemo.service;

import com.posttask.posttaskdemo.entity.Comment;
import com.posttask.posttaskdemo.entity.Post;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(int theId);

    public List<Comment> getCommentsByPostId(int postId);

    void save(Comment theComment);

    void deleteById(int theId);
}
