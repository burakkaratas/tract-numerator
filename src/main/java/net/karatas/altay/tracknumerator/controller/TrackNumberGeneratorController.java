package net.karatas.altay.tracknumerator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
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

@Api(value = "", description = "")
@RestController
@RequestMapping(value = RestConstants.REST_URL)
@RequiredArgsConstructor
public class TrackNumberGeneratorController {

  private final ITractNumberService tractNumeratorService;

  @ApiOperation(value = "", response = Object.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = ""),
      @ApiResponse(code = 404, message = "")
  })
  @PostMapping(value = RestConstants.GENERATE_URL, consumes = RestConstants.APPLICATION_JSON, produces = RestConstants.APPLICATION_JSON)
  public ResponseEntity<BaseRestResponse<TractNumberGenerateResponseDTO>> generate(
      @ApiParam(value = "", required = true)
      @RequestBody @Valid TractNumberGenerateRequestDTO requestDTO) {
    TractNumberGenerateResponseDTO result = tractNumeratorService.generate(requestDTO);
    return new ResponseEntity<>(SuccessRestResponse.create(result), HttpStatus.OK);
  }
}
