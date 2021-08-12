package io.grumpyprogrammer.springmongodemo.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Post> getAll() {
        return service.getAll();
    }

    @GetMapping(params = "id", produces = APPLICATION_JSON_VALUE)
    public List<Post> getAllById(@RequestParam(name = "id") Set<String> ids) {
        return service.getAllById(ids);
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Post getById(@PathVariable String id) {
        return service.getById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Post create(@RequestBody Post post) {
        return service.create(post);
    }

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Post update(@PathVariable String id, @RequestBody Post post) {
        return service.update(id, post)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
