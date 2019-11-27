package net.karatas.altay.tracknumerator.dto.tractnumber;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.model.Coordinate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class TractNumberGenerateResponseDTO extends BaseDTO {

  @ApiModelProperty
  private List<Coordinate> coordinates;
}
