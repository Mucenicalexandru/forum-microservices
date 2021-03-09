package com.forum.comment.service.controller;

import com.forum.comment.service.model.Comment;
import com.forum.comment.service.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/by-commentId/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/by-postId/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId){
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/by-userId/{userId}")
    public List<Comment> getAllCommentsByUserId(@PathVariable Long userId){
        return commentService.getCommentsByUserId(userId);
    }

    @PostMapping("/add")
    public void addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

}
