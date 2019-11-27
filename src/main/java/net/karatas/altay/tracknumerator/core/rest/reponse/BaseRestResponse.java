package net.karatas.altay.tracknumerator.core.rest.reponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class BaseRestResponse<B extends BaseDTO> implements Serializable {

  @ApiModelProperty
  private String responseStatus;

  @ApiModelProperty
  private String transaction;

  @ApiModelProperty
  private RestException errors;

  @ApiModelProperty
  private B body;


}
