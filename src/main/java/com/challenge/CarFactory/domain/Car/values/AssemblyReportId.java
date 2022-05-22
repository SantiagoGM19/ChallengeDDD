package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.Identity;

public class AssemblyReportId extends Identity {

    public AssemblyReportId(){

    }

    private AssemblyReportId(String id){
        super(id);
    }

    public static AssemblyReportId of(String id){
        return new AssemblyReportId(id);
    }
}
