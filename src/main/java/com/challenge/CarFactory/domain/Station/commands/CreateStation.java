package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.StationManager;
import com.challenge.CarFactory.domain.Station.values.DayReportId;
import com.challenge.CarFactory.domain.Station.values.StationId;
import com.challenge.CarFactory.domain.Station.values.Type;

public class CreateStation extends Command {

    private final StationId entityId;
    private final DayReportId dayReportId;
    private final Type type;

    public CreateStation(StationId entityId, DayReportId dayReportId, Type type) {
        this.entityId = entityId;
        this.dayReportId = dayReportId;
        this.type = type;
    }

    public StationId getEntityId() {
        return entityId;
    }

    public DayReportId getDayReportId() {
        return dayReportId;
    }

    public Type getType() {
        return type;
    }
}
