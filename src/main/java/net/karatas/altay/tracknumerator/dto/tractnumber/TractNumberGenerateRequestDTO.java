package net.karatas.altay.tracknumerator.dto.tractnumber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TractNumberGenerateRequestDTO extends BaseDTO {
    @Min(value = 0, message = "validation.numberOfSize.min")
    private Long numberOfSize;
    @Pattern(regexp = "0[xX][0-9a-fA-F]+", message = "validation.MaxNumber.pattern")
    private String minNumber;
    @Pattern(regexp = "0[xX][0-9a-fA-F]+", message = "validation.MinNumber.pattern")
    private String maxNumber;
}
