package net.karatas.altay.tracknumerator.service;

import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateRequestDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateResponseDTO;

public interface ITractNumberService {
    TractNumberGenerateResponseDTO generate(TractNumberGenerateRequestDTO requestDTO);
}
