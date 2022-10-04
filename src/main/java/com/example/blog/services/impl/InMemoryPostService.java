package com.example.blog.services.impl;

import com.example.blog.dto.Post;
import com.example.blog.services.api.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryPostService implements PostService {

    private final List<Post> posts = new ArrayList<>(Arrays.asList(
            Post.builder()
                    .title("FirstTitle")
                    .body("FirstBody")
                    .image("/img/1.jpg")
                    .build(),
            Post.builder()
                    .title("SecondTitle")
                    .image("/img/2.jpg")
                    .body("SecondBody")
                    .build(),
            Post.builder()
                    .title("ThirdTitle")
                    .image("/img/3.jpg")
                    .body("ThirdBody")
                    .build()));

    @Override
    public List<Post> search(String query) {
        return query != null && !query.isEmpty() ?
                posts.stream()
                        .filter(post -> post.getTitle().toLowerCase().matches(".*" + query.toLowerCase() + ".*"))
                        .collect(Collectors.toList())
                :
                posts;
    }
}
