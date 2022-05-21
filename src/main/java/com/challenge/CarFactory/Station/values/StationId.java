package com.challenge.CarFactory.Station.values;

import co.com.sofka.domain.generic.Identity;

public class StationId extends Identity {

    public StationId(){

    }

    private StationId(String id){
        super(id);
    }

    public static StationId of(String id){
        return new StationId(id);
    }
}
