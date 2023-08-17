package com.example.vaccinationBookingSystem.Exception;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(int id){
        super("No User Found with id: "+id+" in the DB.");
    }
}
