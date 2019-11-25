package net.karatas.altay.tracknumerator.core.rest.reponse;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.karatas.altay.tracknumerator.core.exception.types.RestException;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseRestResponse<B extends BaseDTO> implements Serializable {

  private String responseStatus;

  private String transaction;

  private RestException errors;

  private B body;


}
