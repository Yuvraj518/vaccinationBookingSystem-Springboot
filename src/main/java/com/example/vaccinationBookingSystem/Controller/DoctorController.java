package com.example.vaccinationBookingSystem.Controller;

import com.example.vaccinationBookingSystem.Dto.RequestDto.DoctorRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.DoctorResponseDTO;
import com.example.vaccinationBookingSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) throws Exception {
        DoctorResponseDTO doctorResponseDTO=doctorService.addDoctor(doctorRequestDTO);
        return new ResponseEntity(doctorResponseDTO, HttpStatusCode.valueOf(201));
    }
}
