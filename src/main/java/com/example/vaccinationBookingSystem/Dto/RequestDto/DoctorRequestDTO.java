package com.example.vaccinationBookingSystem.Dto.RequestDto;

import com.example.vaccinationBookingSystem.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorRequestDTO {
    String name;
    int age;
    String emailId;
    String mobileNo;
    Gender gender;
    int centerId;
}
