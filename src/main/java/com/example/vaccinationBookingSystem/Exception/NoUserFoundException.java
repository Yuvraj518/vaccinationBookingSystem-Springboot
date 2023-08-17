package com.example.vaccinationBookingSystem.Exception;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(){
        super("No User Found in the DB.");
    }
}
