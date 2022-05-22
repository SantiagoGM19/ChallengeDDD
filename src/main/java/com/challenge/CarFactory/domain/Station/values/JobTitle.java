package com.challenge.CarFactory.domain.Station.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class JobTitle implements ValueObject<String> {

    private final String value;

    public JobTitle(String value){
        this.value = Objects.requireNonNull(value, "Job tile null, it is required");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The job title can not be empty");
        }
        if(this.value.length() > 40){
            throw new IllegalArgumentException("The job title can only be 40 characters long");
        }

        if(this.value.length() < 10){
            throw new IllegalArgumentException("The job title is required to be 10 characters at least");
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
        JobTitle that = (JobTitle) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
