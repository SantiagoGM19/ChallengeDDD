package com.challenge.CarFactory.Car.values;

import co.com.sofka.domain.generic.ValueObject;

public class TypePiece implements ValueObject<TypePiece.Value> {
    @Override
    public TypePiece.Value value() {
        return null;
    }

    public interface Value{
        String type();
        String quality();
    }
}
