package com.challenge.CarFactory.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Station.values.Shift;

public class ChangeShiftStationManager extends Command {

    private final Shift shift;

    public ChangeShiftStationManager(Shift shift) {
        this.shift = shift;
    }

    public Shift getShift() {
        return shift;
    }
}
