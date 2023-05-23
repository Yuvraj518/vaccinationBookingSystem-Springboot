package com.example.vaccinationBookingSystem.Service.impl;

import com.example.vaccinationBookingSystem.Dto.RequestDto.UserRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.UserResponseDTO;
import com.example.vaccinationBookingSystem.Model.User;
import com.example.vaccinationBookingSystem.Repository.UserRepository;
import com.example.vaccinationBookingSystem.Service.UserService;
import com.example.vaccinationBookingSystem.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService_impl implements UserService {

    @Autowired
    UserRepository userRepository;
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user= UserTransformer.UserRequestDtoToUser(userRequestDTO);
        User savedUser=userRepository.save(user);
        UserResponseDTO userResponseDTO=UserTransformer.UserToUserResponseDto(savedUser);
        return userResponseDTO;
    }

    @Override
    public User getByemailId(String id) throws Exception {
        Optional<User> op1=userRepository.findByemailId(id);
        if(op1.isEmpty()){
            throw new Exception("email id doesn't exist");
        }
        return op1.get();
    }

    @Override
    public List<String> getUsersAbove(int id) {
        List<User> userList=userRepository.getAboveGivenAge(id);
        List<String> list=new ArrayList<>();
        for(User x:userList){
            list.add(x.getName());
        }
        return list;
    }
}
