package com.forum.comment.service.repository;

import com.forum.comment.service.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostId(Long id);
    List<Comment> findAllByUserId(Long userId);
}
