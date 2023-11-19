package com.posttask.posttaskdemo.service;

import com.posttask.posttaskdemo.dao.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.posttask.posttaskdemo.entity.Comment;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository theCommentRepository) {
        this.commentRepository = theCommentRepository;
    }
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int theId) {
        Optional<Comment> result = commentRepository.findById(theId);

        Comment theComment = null;

        if (result.isPresent()) {
            theComment = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find Post id - " + theId);
        }

        return theComment;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        return commentRepository.findByPostId(postId);
    }


    @Override
    public void save(Comment theComment) {
       commentRepository.save(theComment);
    }

    @Override
    public void deleteById(int theId) {
        commentRepository.deleteById(theId);
    }
}
