package com.challenge.CarFactory.Station.values;

import co.com.sofka.domain.generic.Identity;

public class StationManagerId extends Identity {

    public StationManagerId(){

    }

    private StationManagerId(String id){
        super(id);
    }

    public static StationManagerId of(String id){
        return new StationManagerId(id);
    }
}
