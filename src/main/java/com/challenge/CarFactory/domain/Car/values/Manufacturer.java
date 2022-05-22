package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Manufacturer implements ValueObject<String> {

    private final String value;

    public Manufacturer(String value){
        this.value = Objects.requireNonNull(value, "manufacturer null, it is required");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The manufacturer can not be empty");
        }
        if(this.value.length() > 50){
            throw new IllegalArgumentException("The manufacturer only can be 50 characters long");
        }
        if(this.value.length() < 3){
            throw new IllegalArgumentException("The manufacturer is required to be 10 characters at least");
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
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
