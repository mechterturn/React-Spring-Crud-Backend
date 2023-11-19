package com.posttask.posttaskdemo.service;

import com.posttask.posttaskdemo.dao.PostRepository;
import com.posttask.posttaskdemo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl  implements PostService{

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository thePostRepository) {
        this.postRepository = thePostRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int theId) {


        Optional<Post> result = postRepository.findById(theId);
        System.out.println(result);
        Post thePost = null;

        if (result.isPresent()) {
            thePost = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find Post id - " + theId);
        }

        return thePost;
    }

    @Override
    public void save(Post thePost) {
        postRepository.save(thePost);
    }

    @Override
    public void deleteById(int theId) {
        postRepository.deleteById(theId);
    }
}
