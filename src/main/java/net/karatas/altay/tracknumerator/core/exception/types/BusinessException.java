package net.karatas.altay.tracknumerator.core.exception.types;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private String message;

    BusinessException(String message) {
        super(message);
    }

}
