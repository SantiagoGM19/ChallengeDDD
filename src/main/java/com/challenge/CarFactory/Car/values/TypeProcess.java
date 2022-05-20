package com.challenge.CarFactory.Car.values;

import co.com.sofka.domain.generic.ValueObject;

public class TypeProcess implements ValueObject<TypeProcess.Value> {

    @Override
    public TypeProcess.Value value() {
        return null;
    }

    public interface Value{
        String type();
        String steps();
    }
}
