package net.karatas.altay.tracknumerator.core.exception.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestException implements Serializable {
    private String errorMessage;
}
