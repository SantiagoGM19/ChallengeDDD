package com.challenge.CarFactory.domain.Station.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Shift implements ValueObject<String> {

    private final String value;

    public Shift(String value){
        this.value = Objects.requireNonNull(value, "Shift null, it is required");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The shift can not be empty");
        }
        if(this.value.length() > 40){
            throw new IllegalArgumentException("The shift can only be 40 characters long");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("The shift is required to be 10 characters at least");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift that = (Shift) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
