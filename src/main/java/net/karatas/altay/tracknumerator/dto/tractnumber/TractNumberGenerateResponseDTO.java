package net.karatas.altay.tracknumerator.dto.tractnumber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TractNumberGenerateResponseDTO extends BaseDTO {
    private List<Coordinate> coordinates;
}
