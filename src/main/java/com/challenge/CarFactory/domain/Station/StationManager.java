package com.challenge.CarFactory.domain.Station;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.domain.Station.values.Identification;
import com.challenge.CarFactory.domain.Station.values.Name;
import com.challenge.CarFactory.domain.Station.values.Shift;
import com.challenge.CarFactory.domain.Station.values.StationManagerId;

import java.util.Objects;

public class StationManager extends Entity<StationManagerId> {

    private Name name;
    private Identification identification;
    private Shift shift;

    public StationManager(StationManagerId entityId, Name name, Identification identification, Shift shift) {
        super(entityId);
        this.name = name;
        this.identification = identification;
        this.shift = shift;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name, "The name can not be null");
    }

    public void updateIdentification(Identification identification){
        this.identification = Objects.requireNonNull(identification, "The identification can not be null");
    }

    public void updateShift(Shift shift){
        this.shift = Objects.requireNonNull(shift, "The shift can not be null");
    }
}
