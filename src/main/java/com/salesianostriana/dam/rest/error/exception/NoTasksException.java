package com.salesianostriana.dam.rest.error.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class NoTasksException extends EntityNotFoundException {
    public NoTasksException(String msg) {}
}
