package com.example.vaccinationBookingSystem.Model;

import com.example.vaccinationBookingSystem.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String location;
    @Enumerated(EnumType.STRING)
    CenterType centerType;
    @OneToMany(mappedBy = "centre",cascade = CascadeType.ALL)
    List<Doctor> doctorList=new ArrayList<>();
}
