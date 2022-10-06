package com.example.blog.services.impl;

import com.example.blog.domain.Post;
import com.example.blog.dto.PostDto;
import com.example.blog.jpa.PostRepository;
import com.example.blog.services.api.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbPostService implements PostService {

    private final PostRepository postRepository;

    public DbPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> search(String query) {
        List<Post> posts = query != null && !query.isEmpty() ?
                postRepository.findAllByTitleLike("%" + query + "%")
                :
                postRepository.findAll();
        return posts.stream().map(post -> PostDto.builder()
                        .title(post.getTitle())
                        .body(post.getBody())
                        .image(post.getImage())
                        .build())
                .collect(Collectors.toList());
    }

//    @PostConstruct
//    public void setup() {
//        postRepository.saveAll(Arrays.asList(
//                        Post.builder()
//                                .title("FirstTitle")
//                                .body("FirstBody")
//                                .image("/img/1.jpg")
//                                .build(),
//                        Post.builder()
//                                .title("SecondTitle")
//                                .image("/img/2.jpg")
//                                .body("SecondBody")
//                                .build(),
//                        Post.builder()
//                                .title("ThirdTitle")
//                                .image("/img/3.jpg")
//                                .body("ThirdBody")
//                                .build()
//                )
//        );
//    }
}
