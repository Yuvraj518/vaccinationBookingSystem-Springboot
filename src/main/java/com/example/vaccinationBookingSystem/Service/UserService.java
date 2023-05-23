package com.example.vaccinationBookingSystem.Service;

import com.example.vaccinationBookingSystem.Dto.RequestDto.UserRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.UserResponseDTO;
import com.example.vaccinationBookingSystem.Model.User;
import com.example.vaccinationBookingSystem.Service.impl.UserService_impl;

import java.util.List;

public interface UserService {

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    User getByemailId(String id) throws Exception;

    List<String> getUsersAbove(int id);
}
