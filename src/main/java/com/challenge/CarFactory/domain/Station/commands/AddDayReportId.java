package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.values.DayReportId;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class AddDayReportId extends Command {

    private final StationId stationId;
    private final DayReportId dayReportId;

    public AddDayReportId(StationId stationId, DayReportId dayReportId){

        this.stationId = stationId;
        this.dayReportId = dayReportId;
    }

    public StationId getStationId(){return stationId;}

    public DayReportId getDayReportId() {
        return dayReportId;
    }
}
