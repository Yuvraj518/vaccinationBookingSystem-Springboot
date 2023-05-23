package com.example.vaccinationBookingSystem.Dto.RequestDto;

import com.example.vaccinationBookingSystem.Enum.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentreRequestDTO {
    String name;
    String location;
    CenterType centerType;

}
