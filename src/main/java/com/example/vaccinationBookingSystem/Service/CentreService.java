package com.example.vaccinationBookingSystem.Service;

import com.example.vaccinationBookingSystem.Dto.RequestDto.CentreRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.CentreResponseDTO;
import com.example.vaccinationBookingSystem.Model.Centre;

import java.util.List;

public interface CentreService {
    CentreResponseDTO addCentre(CentreRequestDTO centreRequestDTO);

    List<String> getAllCentres();
}
