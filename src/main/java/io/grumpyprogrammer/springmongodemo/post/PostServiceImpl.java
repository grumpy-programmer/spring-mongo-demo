package io.grumpyprogrammer.springmongodemo.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    private final PostUpdater updater;

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Post> getAllById(Set<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Optional<Post> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Post create(Post post) {
        return repository.insert(post);
    }

    @Override
    public Optional<Post> update(String id, Post post) {
        return getById(id)
                .map(target -> updater.update(target, post))
                .map(repository::save);
    }

    @Override
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new PostNotFoundException(id);
        }

        repository.deleteById(id);
    }

}
