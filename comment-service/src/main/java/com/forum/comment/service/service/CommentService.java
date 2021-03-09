package com.forum.comment.service.service;

import com.forum.comment.service.model.Comment;
import com.forum.comment.service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId){
        return commentRepository.findById(commentId).get();
    }

    public List<Comment> getAllCommentsByPostId(Long postId){
        return commentRepository.findAllByPostId(postId);
    }

    public List<Comment> getCommentsByUserId(Long userId){
        return commentRepository.findAllByUserId(userId);
    }

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

}
