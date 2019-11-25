package net.karatas.altay.tracknumerator.dto.tractnumber.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate implements Serializable {

  private Integer x;
  private Integer y;
  private String value;
  private Boolean assigned;
}
