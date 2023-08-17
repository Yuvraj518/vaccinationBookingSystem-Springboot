package com.example.vaccinationBookingSystem.Controller;

import com.example.vaccinationBookingSystem.Dto.RequestDto.UserRequestDTO;
import com.example.vaccinationBookingSystem.Dto.ResponseDto.UserResponseDTO;
import com.example.vaccinationBookingSystem.Model.User;
import com.example.vaccinationBookingSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO savedUser= userService.addUser(userRequestDTO);
        return new ResponseEntity(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/get/{emailId}")
    public ResponseEntity getByEmailId(@PathVariable String emailId) throws Exception {
        User user=userService.getByemailId(emailId);
        return new ResponseEntity(user,HttpStatus.FOUND);
    }

    @GetMapping("/get-above/{age}")
    public ResponseEntity getUsersAbove(@PathVariable int age){
        List<String> list=userService.getUsersAbove(age);
        return new ResponseEntity(list, HttpStatusCode.valueOf(200));
    }
}
