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
@Table(name = "user")
@Builder
public class User {
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
    boolean isDose1Taken;
    boolean isDose2Taken;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose1 dose1;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Dose2 dose2;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Appointment> appoinmentList=new ArrayList<>();

}
