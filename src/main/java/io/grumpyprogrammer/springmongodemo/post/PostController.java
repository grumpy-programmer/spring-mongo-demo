package io.grumpyprogrammer.springmongodemo.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository repository;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Post> getAll() {
        return repository.findAll();
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Post getById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "post with id " + id + " not found"));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Post create(@RequestBody Post post) {
        return repository.insert(post);
    }
}
