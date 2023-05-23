package com.example.vaccinationBookingSystem.Service;

import com.example.vaccinationBookingSystem.Dto.RequestDto.DoctorRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.DoctorResponseDTO;

public interface DoctorService {
    DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws Exception;
}
