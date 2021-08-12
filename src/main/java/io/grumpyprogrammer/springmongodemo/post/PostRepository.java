package io.grumpyprogrammer.springmongodemo.post;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findAllById(Collection<String> id);

}
