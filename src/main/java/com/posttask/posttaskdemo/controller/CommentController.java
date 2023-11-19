package com.posttask.posttaskdemo.controller;


import com.posttask.posttaskdemo.entity.Comment;
import com.posttask.posttaskdemo.entity.Post;
import com.posttask.posttaskdemo.service.CommentService;
import com.posttask.posttaskdemo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService theCommentService, PostService thePostService) {
        commentService = theCommentService;
        postService = thePostService;
    }
    //		get list of post cpmment
    @GetMapping("/post/{id}/comments")
    public List<Comment> listComment( @PathVariable int id) {
        System.out.println( "hello line no 26");
        List<Comment> theComments = commentService.getCommentsByPostId(id);

        return theComments;
    }

    //    add single comment
    @PostMapping("/post/{id}/comments")
    public String saveComment(@RequestBody Comment theComment, @PathVariable int id){
        System.out.println(theComment);
        System.out.println(id);
        Post post = postService.findById(id);
        System.out.println(post);
        theComment.setPost(post);
        commentService.save(theComment);
        return "saved";
    }


}
