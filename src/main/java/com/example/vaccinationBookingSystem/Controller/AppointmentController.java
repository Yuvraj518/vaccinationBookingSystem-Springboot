package com.example.vaccinationBookingSystem.Controller;

import com.example.vaccinationBookingSystem.Dto.RequestDto.AppointmentRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.AppointmentResponseDTO;
import com.example.vaccinationBookingSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) throws Exception {
        AppointmentResponseDTO appointmentResponseDTO=appointmentService.bookAppointment(appointmentRequestDTO);
        return new ResponseEntity(appointmentResponseDTO, HttpStatus.CREATED);
    }
}
