package com.example.vaccinationBookingSystem.Repository;

import com.example.vaccinationBookingSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user as s where s.email_id=:id",nativeQuery = true)
    Optional<User> findByemailId(String id);
    @Query(value = "select name from user u where u.age > :age",nativeQuery = true)
    List<String> getAboveGivenAge(int age);
}

