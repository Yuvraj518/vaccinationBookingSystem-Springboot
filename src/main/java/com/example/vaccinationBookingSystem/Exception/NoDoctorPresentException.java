package com.example.vaccinationBookingSystem.Exception;

public class NoDoctorPresentException extends Exception{
    public NoDoctorPresentException(int id){
        super("No Dr. found with id: "+id+" in the DB.");
    }
}
