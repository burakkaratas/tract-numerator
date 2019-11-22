package net.karatas.altay.tracknumerator.dto.tractnumber.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate implements Serializable {
    private Integer x;
    private Integer y;
    private String value;
}
