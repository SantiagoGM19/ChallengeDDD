package com.challenge.CarFactory.Car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProcessType implements ValueObject<ProcessType.Value> {

    private final String type;
    private final String steps;

    public ProcessType(String type, String steps){

        this.type = Objects.requireNonNull(type, "the type is required");
        this.steps = Objects.requireNonNull(steps, "the steps are required");

        if(this.type.isBlank()){
            throw new IllegalArgumentException("The type can not be empty");
        }
        if(this.type.length() > 50){
            throw new IllegalArgumentException("The type only can be 50 characters long");
        }
        if(this.type.length() < 10){
            throw new IllegalArgumentException("The type is required to be 10 characters at least");
        }

        if(this.steps.isBlank()){
            throw new IllegalArgumentException("The steps can not be empty");
        }
        if(this.steps.length() > 300){
            throw new IllegalArgumentException("The steps only can be 300 characters long");
        }
        if(this.steps.length() < 100){
            throw new IllegalArgumentException("The steps is required to be 100 characters at least");
        }

    }

    @Override
    public ProcessType.Value value() {
        return new Value() {
            @Override
            public String type() {
                return type;
            }

            @Override
            public String steps() {
                return steps;
            }
        };
    }

    public interface Value{
        String type();
        String steps();
    }
}
