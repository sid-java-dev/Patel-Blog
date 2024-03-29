package com.blog.patelBlog.controller;

import com.blog.patelBlog.payload.PostDto;
import com.blog.patelBlog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts?id=1
    @GetMapping
    public ResponseEntity<PostDto> getPostById(@RequestParam long id) {
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam long id) {
        String message = postService.deletePostById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@RequestParam long id){
        PostDto postDto1 = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postDto1,HttpStatus.OK);
    }

}
