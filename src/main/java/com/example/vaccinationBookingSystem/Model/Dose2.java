package com.example.vaccinationBookingSystem.Model;

import com.example.vaccinationBookingSystem.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dose2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String doseID;       //UUID
    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;
    @CreationTimestamp
    Date vaccnicationDate;
    @OneToOne
    @JoinColumn
    User user;
}
