package com.challenge.CarFactory.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Station.values.DayReportId;

public class AddDayReportId extends Command {

    private final DayReportId dayReportId;

    public AddDayReportId(DayReportId dayReportId){
        this.dayReportId = dayReportId;
    }

    public DayReportId getDayReportId() {
        return dayReportId;
    }
}
