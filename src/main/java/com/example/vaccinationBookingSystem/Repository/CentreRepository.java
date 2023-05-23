package com.example.vaccinationBookingSystem.Repository;

import com.example.vaccinationBookingSystem.Model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<Centre,Integer> {
}
