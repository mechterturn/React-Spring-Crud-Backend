package com.posttask.posttaskdemo.controller;

import com.posttask.posttaskdemo.entity.Post;
import com.posttask.posttaskdemo.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class PostController {

    private PostService postService;

    public PostController(PostService thePostService) {
        postService = thePostService;
    }

    //		get list of posts
    @GetMapping("/posts")
    public List<Post> listPost() {
        System.out.println("hello");
        List<Post> thePosts = postService.findAll();
        return thePosts;
    }

//    add single post
    @PostMapping("/post")
    public String savePost(@RequestBody Post thePost ){
        System.out.println(thePost);
//		save the employee
        postService.save(thePost);

//		use a redirect to prevent duplicate entries
        return "saved";

    }

    //    get single post
    @GetMapping("/post/{id}")
    public  Post getPostById(@PathVariable  int id) {

        Post thePost = postService.findById(id);

        return  thePost;

    }
    //   update single post
    @PostMapping("/post/update/{id}")
    public String updatePost(@RequestBody Post thePost, @PathVariable int  id) {
        System.out.println(thePost);
        Post existingPost = postService.findById(id);
        System.out.println(id);
        System.out.println(thePost);
        // Update the fields of the existing post
        existingPost.setName(thePost.getName());
        existingPost.setTitle(thePost.getTitle());
        existingPost.setDescription(thePost.getDescription());
        existingPost.setAuthor(thePost.getAuthor());

        // Save the updated post
         postService.save(existingPost);

        return "updated ";

    }


    //   delete single post
    @DeleteMapping("/post/delete/{id}")
   public void  deleteById(@PathVariable int id) {
        System.out.println(id);

        postService.deleteById(id);
    }

}
