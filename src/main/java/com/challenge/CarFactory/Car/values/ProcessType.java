package com.challenge.CarFactory.Car.values;

import co.com.sofka.domain.generic.ValueObject;

public class ProcessType implements ValueObject<ProcessType.Value> {

    @Override
    public ProcessType.Value value() {
        return null;
    }

    public interface Value{
        String type();
        String steps();
    }
}
