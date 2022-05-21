package com.challenge.CarFactory.Station;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.Station.values.AmountProduced;
import com.challenge.CarFactory.Station.values.DayReportId;
import com.challenge.CarFactory.Station.values.Description;

import java.util.Objects;

public class DayReport extends Entity<DayReportId> {

    private Description description;
    private AmountProduced amountProduced;

    public DayReport(DayReportId entityId, Description description, AmountProduced amountProduced) {
        super(entityId);
        this.description = description;
        this.amountProduced = amountProduced;
    }

    public void addDescription(Description description){
        this.description = Objects.requireNonNull(description, "The description can not be null");
    }

    public void updateAmountProduced(AmountProduced amountProduced){
        this.amountProduced = Objects.requireNonNull(amountProduced, "The amount produced can not be null");
    }

    public Description description() {
        return description;
    }

    public AmountProduced amountProduced() {
        return amountProduced;
    }
}
