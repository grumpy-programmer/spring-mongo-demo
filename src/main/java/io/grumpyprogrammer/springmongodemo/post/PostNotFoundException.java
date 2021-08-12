package io.grumpyprogrammer.springmongodemo.post;

import io.grumpyprogrammer.springmongodemo.common.exception.NotFoundException;

public class PostNotFoundException extends NotFoundException {

    public PostNotFoundException(String id) {
        super(String.format("post with id %s not found", id));
    }

}
