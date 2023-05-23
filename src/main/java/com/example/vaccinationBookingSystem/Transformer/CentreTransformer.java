package com.example.vaccinationBookingSystem.Transformer;

import com.example.vaccinationBookingSystem.Dto.RequestDto.CentreRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.CentreResponseDTO;
import com.example.vaccinationBookingSystem.Model.Centre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CentreTransformer {
    public static Centre CentreRequestDTOtoCentre(CentreRequestDTO centreRequestDTO){
        return Centre.builder().name(centreRequestDTO.getName())
                .location(centreRequestDTO.getLocation())
                .centerType(centreRequestDTO.getCenterType()).build();
    }
    public static CentreResponseDTO CentretoCentreResponseDTO(Centre centre){
        return new CentreResponseDTO("Congrats ,"+centre.getName()+" have sucessfully registred");
    }
}
