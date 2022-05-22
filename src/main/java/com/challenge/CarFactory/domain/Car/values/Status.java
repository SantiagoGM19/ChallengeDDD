package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Status implements ValueObject<Boolean> {

    private final Boolean value;

    public Status(Boolean value){
        this.value = Objects.requireNonNull(value, "The status is required");
    }


    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(value, status.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
