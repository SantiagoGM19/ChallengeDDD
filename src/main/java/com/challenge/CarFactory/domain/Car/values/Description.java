package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {

    private final String value;

    public Description(String value){
        this.value = Objects.requireNonNull(value, "Description null, it is required");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The description can not be empty");
        }
        if(this.value.length() > 500){
            throw new IllegalArgumentException("The description can only be 500 characters long");
        }

        if(this.value.length() < 35){
            throw new IllegalArgumentException("The description is required to be 35 characters at least");
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
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
