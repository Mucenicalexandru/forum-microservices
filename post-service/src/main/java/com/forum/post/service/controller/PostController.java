package com.forum.post.service.controller;

import com.forum.post.service.model.Post;
import com.forum.post.service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/all")
    public List<Post> getAllComments(){
        return postService.getAll();
    }

    @GetMapping("/by-post-id/{postId}")
    public Post getCommentById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @GetMapping("/by-user-id/{userId}")
    public List<Post> getCommentByUserId(@PathVariable Long userId){
        return postService.getPostByUserId(userId);
    }

    @PostMapping("/add")
    public void addComment(@RequestBody Post post){
        postService.addPost(post);
    }

    @PutMapping("/edit/{postId}")
    public void editComment(@PathVariable Long postId, @RequestBody Post post){
        Post postToUpdate = postService.getPostById(postId);

        postToUpdate.setPostId(post.getPostId());

        postService.addPost(postToUpdate);
    }


    @DeleteMapping("/{postId}")
    public void deleteComment(@PathVariable Long postId){
        postService.deletePost(postId);
    }
}

