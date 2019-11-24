package net.karatas.altay.tracknumerator.controller;

import lombok.RequiredArgsConstructor;
import net.karatas.altay.tracknumerator.constants.RestConstants;
import net.karatas.altay.tracknumerator.core.rest.reponse.BaseRestResponse;
import net.karatas.altay.tracknumerator.core.rest.reponse.builder.SuccessRestResponse;
import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateRequestDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateResponseDTO;
import net.karatas.altay.tracknumerator.service.ITractNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = RestConstants.REST_URL)
@RequiredArgsConstructor
public class TrackNumberGeneratorController {

    private final ITractNumberService tractNumeratorService;

    @PostMapping(value = RestConstants.GENERATE_URL, consumes = RestConstants.APPLICATION_JSON, produces = RestConstants.APPLICATION_JSON)
    public ResponseEntity<BaseRestResponse<TractNumberGenerateResponseDTO>> generate(@RequestBody @Valid TractNumberGenerateRequestDTO requestDTO) {
        TractNumberGenerateResponseDTO result = tractNumeratorService.generate(requestDTO);
        return new ResponseEntity<>(SuccessRestResponse.create(result), HttpStatus.OK);
    }
}
