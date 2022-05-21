package com.challenge.CarFactory.Station.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<String> {

    private final String value;

    public Type(String value){
        this.value = Objects.requireNonNull(value, "Type null, it is required");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The type can not be empty");
        }
        if(this.value.length() > 40){
            throw new IllegalArgumentException("The type can only be 40 characters long");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("The type is required to be 10 characters at least");
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
        Type that = (Type) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
