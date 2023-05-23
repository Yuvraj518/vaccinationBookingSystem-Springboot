package com.example.vaccinationBookingSystem.Model;

import com.example.vaccinationBookingSystem.Enum.Gender;
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
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    @Column(name = "email_id",nullable = false,unique = true)
    String emailID;
    @Column(name = "mobile_no",nullable = false,unique = true)
    String mobileNo;
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Appointment> appoinmentList=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    Centre centre;

}
