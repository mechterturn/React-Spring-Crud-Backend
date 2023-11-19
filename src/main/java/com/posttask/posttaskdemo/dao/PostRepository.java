package com.posttask.posttaskdemo.dao;

import com.posttask.posttaskdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


//	add a method  to sort by lsst name

    public List<Post> findAll();
}
