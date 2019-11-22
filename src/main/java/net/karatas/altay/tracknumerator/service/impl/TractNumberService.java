package net.karatas.altay.tracknumerator.service.impl;

import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateRequestDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateResponseDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.model.Coordinate;
import net.karatas.altay.tracknumerator.service.ITractNumberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TractNumberService implements ITractNumberService {

    private static final Random RANDOM = new Random();

    @Override
    public TractNumberGenerateResponseDTO generate(TractNumberGenerateRequestDTO requestDTO) {
        Long numberOfSize = requestDTO.getNumberOfSize();
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < numberOfSize; i++) {
            Coordinate coordinate = new Coordinate();

        }
        return new TractNumberGenerateResponseDTO(coordinates);
    }


}
