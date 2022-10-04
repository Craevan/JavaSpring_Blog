package com.example.blog.controllers;

import com.example.blog.services.impl.InMemoryPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    private final InMemoryPostService inMemoryPostService;

    public PostController(InMemoryPostService inMemoryPostService) {
        this.inMemoryPostService = inMemoryPostService;
    }

    @GetMapping("/")
    public String hello(Model model, @RequestParam(required = false) String query) {
        model.addAttribute("posts", inMemoryPostService.search(query));
        return "hello";
    }
}
