package com.example.vaccinationBookingSystem.Transformer;

import com.example.vaccinationBookingSystem.Dto.RequestDto.DoctorRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.CentreResponseDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.DoctorResponseDTO;
import com.example.vaccinationBookingSystem.Model.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {
    public static Doctor DoctorRequestDTOtoDoctor(DoctorRequestDTO doctorRequestDTO) {
        return Doctor.builder().name(doctorRequestDTO.getName())
                .age(doctorRequestDTO.getAge()).emailID(doctorRequestDTO.getEmailId())
                .mobileNo(doctorRequestDTO.getMobileNo())
                .gender(doctorRequestDTO.getGender()).build();
    }

    public static DoctorResponseDTO Dotor_CentreResponsetoDoctorResponse(Doctor doctor, CentreResponseDTO centreResponseDTO) {
        DoctorResponseDTO drt1;
        drt1 = DoctorResponseDTO.builder()
                .name(doctor.getName()).emailId(doctor.getEmailID())
                .centreResponseDTO(centreResponseDTO).build();
        return drt1;
    }
}
