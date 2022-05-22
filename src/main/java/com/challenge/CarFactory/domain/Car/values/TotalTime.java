package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TotalTime implements ValueObject<Integer> {

    //the total time is measured in hours
    private final Integer value;

    public TotalTime(Integer value){
        this.value = value;
        if(value > 24){
            throw new IllegalArgumentException("The maximum total time must be 24 hours");
        }
        if(value < 16){
            throw new IllegalArgumentException("The minimum total time must be 16 hours");
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
        TotalTime totalTime = (TotalTime) o;
        return Objects.equals(value, totalTime.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
