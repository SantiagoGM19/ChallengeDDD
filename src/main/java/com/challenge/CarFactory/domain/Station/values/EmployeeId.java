package com.challenge.CarFactory.domain.Station.values;

import co.com.sofka.domain.generic.Identity;

public class EmployeeId extends Identity {

    public EmployeeId(){

    }

    private EmployeeId(String id){
        super(id);
    }

    public static EmployeeId of(String id){
        return new EmployeeId(id);
    }
}
