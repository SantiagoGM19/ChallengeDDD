package com.challenge.CarFactory.domain.Car;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.Description;
import com.challenge.CarFactory.domain.Car.values.TotalTime;

import java.util.Objects;

public class AssemblyReport extends Entity<AssemblyReportId> {

    private TotalTime totalTime;
    private Description description;

    public AssemblyReport(AssemblyReportId entityId, TotalTime totalTime, Description description) {
        super(entityId);
        this.totalTime = totalTime;
        this.description = description;
    }

    public void updateTotalTime(TotalTime totalTime){
        this.totalTime = Objects.requireNonNull(totalTime, "The total time must be defined, it is null");
    }

    public void addDescription(Description description){
        this.description = Objects.requireNonNull(description, "The description must be defined, it is null");
    }

    public TotalTime totalTime() {
        return totalTime;
    }

    public Description description() {
        return description;
    }

}
