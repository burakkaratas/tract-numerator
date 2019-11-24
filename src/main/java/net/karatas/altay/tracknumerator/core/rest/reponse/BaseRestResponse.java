package net.karatas.altay.tracknumerator.core.rest.reponse;

import lombok.*;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;
import net.karatas.altay.tracknumerator.core.exception.types.RestException;

import java.io.Serializable;

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
