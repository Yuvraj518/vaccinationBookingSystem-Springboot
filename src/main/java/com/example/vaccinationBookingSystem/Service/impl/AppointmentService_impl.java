package com.example.vaccinationBookingSystem.Service.impl;

import com.example.vaccinationBookingSystem.Dto.RequestDto.AppointmentRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.AppointmentResponseDTO;
import com.example.vaccinationBookingSystem.Enum.DoseNo;
import com.example.vaccinationBookingSystem.Exception.AlreadyTakenDose1Exception;
import com.example.vaccinationBookingSystem.Model.*;
import com.example.vaccinationBookingSystem.Repository.AppointmentRepository;
import com.example.vaccinationBookingSystem.Repository.DoctorRepository;
import com.example.vaccinationBookingSystem.Repository.UserRepository;
import com.example.vaccinationBookingSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service

public class AppointmentService_impl implements AppointmentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO appointmentRequestDTO) throws Exception,RuntimeException {
        Optional<User> op1=userRepository.findById(appointmentRequestDTO.getUserId());
        if(op1.isEmpty()){
            throw new Exception("No User found with userId: "+appointmentRequestDTO.getUserId());
        }
        Optional<Doctor> op2=doctorRepository.findById(appointmentRequestDTO.getDoctorId());
        if(op2.isEmpty()){
            throw new Exception("No Dr. found with doctorId: "+appointmentRequestDTO.getDoctorId());
        }
        User user=op1.get();
        Doctor doctor=op2.get();
        if(appointmentRequestDTO.getDoseNo()== DoseNo.DOSE_1 && !user.isDose1Taken()){
            user.setDose1Taken(true);
            Dose1 dose1=new Dose1();
            dose1.setDoseID(String.valueOf(UUID.randomUUID()));
            dose1.setVaccineType(appointmentRequestDTO.getVaccineType());
            dose1.setUser(user);
            user.setDose1(dose1);
        }
        else if(appointmentRequestDTO.getDoseNo()==DoseNo.DOSE_1 && user.isDose1Taken()){
            throw new AlreadyTakenDose1Exception();//Exception("Already taken Dose 1");
        }
        else if(appointmentRequestDTO.getDoseNo()==DoseNo.DOSE_2 && !user.isDose1Taken()){
            throw new Exception("First register for Dose 1");
        }
        else if(appointmentRequestDTO.getDoseNo()==DoseNo.DOSE_2 && user.isDose2Taken()){
            throw new Exception("Already taken dose 2");
        }
        else{
            user.setDose2Taken(true);
            Dose2 dose2=new Dose2();
            dose2.setDoseID(String.valueOf(UUID.randomUUID()));
            dose2.setVaccineType(appointmentRequestDTO.getVaccineType());
            dose2.setUser(user);
            user.setDose2(dose2);
        }
        Appointment appointment= new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setUser(user);
        appointment.setDoctor(doctor);
        appointment.setDoseNo(appointmentRequestDTO.getDoseNo());

        user.getAppoinmentList().add(appointment);
        doctor.getAppoinmentList().add(appointment);

        Appointment savedAppointment=appointmentRepository.save(appointment);
        return AppointmentResponseDTO.builder().
                appointmentID(savedAppointment.getAppointmentId())
                .userName(user.getName()).doctorName(doctor.getName())
                .centreName(doctor.getCentre().getName()).build();
    }
}
