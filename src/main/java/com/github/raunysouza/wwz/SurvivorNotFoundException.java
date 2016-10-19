package com.github.raunysouza.wwz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author raunysouza
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SurvivorNotFoundException extends RuntimeException {
    public SurvivorNotFoundException() {
        super("Survivor not found");
    }
}
