package com.example.vaccinationBookingSystem.Transformer;

import com.example.vaccinationBookingSystem.Dto.RequestDto.UserRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.UserResponseDTO;
import com.example.vaccinationBookingSystem.Model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {
    public static User UserRequestDtoToUser(UserRequestDTO userRequestDTO){
        User user =new User();
        user.setName(userRequestDTO.getName());
        user.setAge(userRequestDTO.getAge());
        user.setEmailID(userRequestDTO.getEmailID());
        user.setMobileNo(userRequestDTO.getMobileNo());
        user.setGender(userRequestDTO.getGender());
        return user;
    }
    public static UserResponseDTO UserToUserResponseDto(User user){
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setMessage("Congrats, You have successfully registered");
        return userResponseDTO;
    }
}
