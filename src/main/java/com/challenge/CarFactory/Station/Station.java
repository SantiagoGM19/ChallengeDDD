package com.challenge.CarFactory.Station;

import co.com.sofka.domain.generic.AggregateEvent;
import com.challenge.CarFactory.Station.values.StationId;

public class Station extends AggregateEvent<StationId> {

    public Station(StationId entityId) {
        super(entityId);
    }
}
