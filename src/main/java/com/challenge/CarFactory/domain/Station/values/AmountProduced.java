package com.challenge.CarFactory.domain.Station.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AmountProduced implements ValueObject<Integer> {

    private final Integer value;

    public AmountProduced(Integer value){
        this.value = Objects.requireNonNull(value, "The amount produced can not be null");
        if(value < 0){
            throw new IllegalArgumentException("The amount produced can not be negative number");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountProduced that = (AmountProduced) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
