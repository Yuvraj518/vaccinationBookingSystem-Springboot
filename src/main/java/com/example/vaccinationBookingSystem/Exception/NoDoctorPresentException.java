package com.example.vaccinationBookingSystem.Exception;

public class NoDoctorPresentException extends Exception{
    public NoDoctorPresentException(){
        super("No Dr. found in the DB.");
    }
}
