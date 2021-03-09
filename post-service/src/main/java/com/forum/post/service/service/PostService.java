package com.forum.post.service.service;

import com.forum.post.service.model.Post;
import com.forum.post.service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll(){
        return postRepository.findAll();
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).get();
    }

    public List<Post> getPostByUserId(Long userId){
        return postRepository.findAllByUserId(userId);
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }


}
