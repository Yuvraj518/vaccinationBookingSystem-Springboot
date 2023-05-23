package com.example.vaccinationBookingSystem.Repository;

import com.example.vaccinationBookingSystem.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {  // 420 ,100 , 20, ===350
}
