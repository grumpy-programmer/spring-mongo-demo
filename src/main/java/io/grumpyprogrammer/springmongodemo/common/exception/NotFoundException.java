package io.grumpyprogrammer.springmongodemo.common.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class NotFoundException extends ResponseStatusException {

    public NotFoundException() {
        super(NOT_FOUND);
    }

    public NotFoundException(String reason) {
        super(NOT_FOUND, reason);
    }

}
