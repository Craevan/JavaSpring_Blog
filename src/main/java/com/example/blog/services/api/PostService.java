package com.example.blog.services.api;

import com.example.blog.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> search(String query);
}
