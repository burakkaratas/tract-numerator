package net.karatas.altay.tracknumerator.service.impl;

import net.karatas.altay.tracknumerator.constants.ApplicationConstants;
import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateRequestDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.TractNumberGenerateResponseDTO;
import net.karatas.altay.tracknumerator.dto.tractnumber.model.Coordinate;
import net.karatas.altay.tracknumerator.service.ITractNumberService;
import net.karatas.altay.tracknumerator.util.HEXUtil;
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

        String minNumber = requestDTO.getMinNumber();
        String maxNumber = requestDTO.getMaxNumber();

        Integer rangeBetweenTwos = HEXUtil.getRangeBetweenTwos(maxNumber, minNumber);

        List<Coordinate> coordinates = new ArrayList<>();
        for (int loopIndex = 0; loopIndex < numberOfSize; loopIndex++) {
            Coordinate coordinate = new Coordinate();
            boolean assigned = loopIndex < rangeBetweenTwos.intValue();
            coordinate.setAssigned(assigned);
            if (assigned) {
                coordinate.setValue(HEXUtil.nextHex(minNumber, loopIndex));
            }
            coordinate.setX(RANDOM.nextInt(ApplicationConstants.MAX_SIZE) * 10);
            coordinate.setY(RANDOM.nextInt(ApplicationConstants.MAX_SIZE) * 10);
            coordinates.add(coordinate);
        }
        return new TractNumberGenerateResponseDTO(coordinates);
    }


}
