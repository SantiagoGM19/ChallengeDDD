package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PieceType implements ValueObject<PieceType.Value> {

    private final String type;
    private final Integer quality;

    public PieceType(String type, Integer quality){
        this.type = Objects.requireNonNull(type, "type is required");
        this.quality = Objects.requireNonNull(quality, "quality is required");
        if(this.type.isBlank()){
            throw new IllegalArgumentException("The type can not be empty");
        }
        if(this.type.length() > 50){
            throw new IllegalArgumentException("The type only can be 50 characters long");
        }
        if(this.type.length() < 3){
            throw new IllegalArgumentException("The type is required to be 3 characters at least");
        }
        if(quality > 5 || quality < 1){
            throw new IllegalArgumentException("The quality must be in a range of 1 to 5");
        }
    }

    @Override
    public PieceType.Value value() {
        return new Value() {
            @Override
            public String type() {
                return type;
            }

            @Override
            public Integer quality() {
                return quality;
            }
        };
    }

    public interface Value{
        String type();
        Integer quality();
    }
}
