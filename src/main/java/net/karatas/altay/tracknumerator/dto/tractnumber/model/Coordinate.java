package net.karatas.altay.tracknumerator.dto.tractnumber.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Coordinate implements Serializable {

  @ApiModelProperty
  private Integer x;

  @ApiModelProperty
  private Integer y;

  @ApiModelProperty
  private String value;

  @ApiModelProperty
  private Boolean assigned;
}
