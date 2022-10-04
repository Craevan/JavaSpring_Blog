package com.example.blog.services.api;

import com.example.blog.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> search(String query);
}
