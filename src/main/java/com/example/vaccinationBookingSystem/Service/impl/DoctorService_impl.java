package com.example.vaccinationBookingSystem.Service.impl;

import com.example.vaccinationBookingSystem.Dto.RequestDto.DoctorRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.CentreResponseDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.DoctorResponseDTO;
import com.example.vaccinationBookingSystem.Model.Centre;
import com.example.vaccinationBookingSystem.Model.Doctor;
import com.example.vaccinationBookingSystem.Repository.CentreRepository;
import com.example.vaccinationBookingSystem.Repository.DoctorRepository;
import com.example.vaccinationBookingSystem.Service.DoctorService;
import com.example.vaccinationBookingSystem.Transformer.CentreTransformer;
import com.example.vaccinationBookingSystem.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DoctorService_impl implements DoctorService {
    @Autowired
    CentreRepository centreRepository;
//    @Autowired
//    DoctorRepository doctorRepository;
    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) throws Exception {
        Optional<Centre> op1=centreRepository.findById(doctorRequestDTO.getCenterId());
        if(op1.isEmpty()){
            throw new Exception("Centre doesn't found");
        }
        Centre centre=op1.get();
        // dto to entity
        Doctor doctor= DoctorTransformer.DoctorRequestDTOtoDoctor(doctorRequestDTO);
        doctor.setCentre(centre);
        //add dr to current list of dr's at that centre
//        Doctor savedDoctor=doctorRepository.save(doctor);
//        centre.getDoctorList().add(savedDoctor);
        centre.getDoctorList().add(doctor);

        Centre savedCentre=centreRepository.save(centre);   // saves both centre and doctor
        //response dto
        CentreResponseDTO centreResponseDTO= CentreTransformer.CentretoCentreResponseDTO(savedCentre);
        DoctorResponseDTO doctorResponseDTO=DoctorTransformer.Dotor_CentreResponsetoDoctorResponse(doctor,centreResponseDTO);
        return doctorResponseDTO;
    }
}
