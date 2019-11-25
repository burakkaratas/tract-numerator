package net.karatas.altay.tracknumerator.core.exception.types;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestException implements Serializable {

  private String errorMessage;
}
