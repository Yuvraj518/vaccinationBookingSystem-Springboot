package com.example.vaccinationBookingSystem.Service;

import com.example.vaccinationBookingSystem.Dto.RequestDto.AppointmentRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.AppointmentResponseDTO;

public interface AppointmentService {
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws Exception;
}
