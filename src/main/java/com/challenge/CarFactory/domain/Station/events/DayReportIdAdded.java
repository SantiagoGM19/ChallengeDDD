package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Station.values.DayReportId;

public class DayReportIdAdded extends DomainEvent {

    private final DayReportId dayReportId;

    public DayReportIdAdded(DayReportId dayReportId){
        super("carfactory.station.dayreportidadded");
        this.dayReportId = dayReportId;
    }

    public DayReportId getDayReportId() {
        return dayReportId;
    }
}
