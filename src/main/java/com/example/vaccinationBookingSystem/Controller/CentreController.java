package com.example.vaccinationBookingSystem.Controller;

import com.example.vaccinationBookingSystem.Dto.RequestDto.CentreRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.CentreResponseDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.UserResponseDTO;
import com.example.vaccinationBookingSystem.Model.Centre;
import com.example.vaccinationBookingSystem.Service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centre")
public class CentreController {
    @Autowired
    CentreService centreService;
    @PostMapping("/add")
    public ResponseEntity addCentre(@RequestBody CentreRequestDTO centreRequestDTO){
        CentreResponseDTO centreResponseDTO =centreService.addCentre(centreRequestDTO);
        return new ResponseEntity(centreResponseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/get-all")
    public ResponseEntity getAllCentres(){
        List<String> centreList=centreService.getAllCentres();
        return new ResponseEntity(centreList,HttpStatus.OK);
    }
}
