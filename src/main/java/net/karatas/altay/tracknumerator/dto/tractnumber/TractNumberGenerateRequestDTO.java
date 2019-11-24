package net.karatas.altay.tracknumerator.dto.tractnumber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static net.karatas.altay.tracknumerator.constants.ApplicationConstants.HEX_REGEX;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TractNumberGenerateRequestDTO extends BaseDTO {

    @NotNull(message = "validation.numberOfSize.notnull")
    @Min(value = 0, message = "validation.numberOfSize.min")
    private Long numberOfSize;

    @NotNull(message = "validation.MinNumber.notnull")
    @Pattern(regexp = HEX_REGEX, message = "validation.MinNumber.pattern")
    private String minNumber;

    @NotNull(message = "validation.MaxNumber.notnull")
    @Pattern(regexp = HEX_REGEX, message = "validation.MaxNumber.pattern")
    private String maxNumber;
}
