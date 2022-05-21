package com.challenge.CarFactory.Car.values;

import co.com.sofka.domain.generic.Identity;

public class ProcessId extends Identity {

    public ProcessId(){

    }

    private ProcessId(String id){
        super(id);
    }

    public static ProcessId of(String id){
        return new ProcessId(id);
    }
}
