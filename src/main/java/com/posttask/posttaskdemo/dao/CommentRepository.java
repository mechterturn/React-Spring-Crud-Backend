package com.posttask.posttaskdemo.dao;

import com.posttask.posttaskdemo.entity.Comment;
import com.posttask.posttaskdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public List<Comment> findAll();
    List<Comment> findByPostId(int postId);

}
