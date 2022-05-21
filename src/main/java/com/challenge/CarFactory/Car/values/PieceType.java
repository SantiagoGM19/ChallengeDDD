package com.challenge.CarFactory.Car.values;

import co.com.sofka.domain.generic.ValueObject;

public class PieceType implements ValueObject<PieceType.Value> {
    @Override
    public PieceType.Value value() {
        return null;
    }

    public interface Value{
        String type();
        String quality();
    }
}
