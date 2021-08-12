package io.grumpyprogrammer.springmongodemo.post;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostService {

    List<Post> getAll();

    List<Post> getAllById(Set<String> ids);

    Optional<Post> getById(String id);

    Post create(Post post);

    Optional<Post> update(String id, Post post);

    void delete(String id);

}
