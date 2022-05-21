package com.challenge.CarFactory.Station.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identification implements ValueObject<String> {

    private final String value;

    public Identification(String value){
        this.value = Objects.requireNonNull(value, "Identification null, it is required");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The identification can not be empty");
        }
        if(this.value.length() > 20){
            throw new IllegalArgumentException("The identification can only be 20 characters long");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("The identification is required to be 10 characters at least");
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
        Identification that = (Identification) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
