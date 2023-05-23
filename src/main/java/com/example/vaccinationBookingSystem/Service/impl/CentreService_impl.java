package com.example.vaccinationBookingSystem.Service.impl;

import com.example.vaccinationBookingSystem.Dto.RequestDto.CentreRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.CentreResponseDTO;
import com.example.vaccinationBookingSystem.Model.Centre;
import com.example.vaccinationBookingSystem.Repository.CentreRepository;
import com.example.vaccinationBookingSystem.Service.CentreService;
import com.example.vaccinationBookingSystem.Transformer.CentreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CentreService_impl implements CentreService {
    @Autowired
    CentreRepository centreRepository;
    @Override
    public CentreResponseDTO addCentre(CentreRequestDTO centreRequestDTO) {
        Centre centre= CentreTransformer.CentreRequestDTOtoCentre(centreRequestDTO);
        Centre savedCentre=centreRepository.save(centre);

        CentreResponseDTO centreResponseDTO=CentreTransformer.CentretoCentreResponseDTO(savedCentre);
        return centreResponseDTO;
    }

    @Override
    public List<String> getAllCentres() {
        List<Centre> centreList=centreRepository.findAll();
        List<String> list=new ArrayList<>();
        for(Centre x: centreList){
            list.add(x.getName());
        }
        return list;
    }
}
