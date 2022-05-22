package com.challenge.CarFactory.domain.Station.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<Name.Value> {

    private final String names;
    private final String lastNames;

    public Name(String names, String lastNames){
        this.names = Objects.requireNonNull(names, "The names can not be null");
        this.lastNames = Objects.requireNonNull(lastNames, "The last names can not be null");

        if(this.names.isBlank()){
            throw new IllegalArgumentException("The names can not be empty");
        }
        if(this.names.length() > 50){
            throw new IllegalArgumentException("The names only can be 50 characters long");
        }
        if(this.names.length() < 3){
            throw new IllegalArgumentException("The names is required to be 3 characters at least");
        }

        if(this.lastNames.isBlank()){
            throw new IllegalArgumentException("The steps can not be empty");
        }
        if(this.lastNames.length() > 60){
            throw new IllegalArgumentException("The last names only can be 60 characters long");
        }
        if(this.lastNames.length() < 3){
            throw new IllegalArgumentException("The last names is required to be 3 characters at least");
        }
    }

    @Override
    public Name.Value value() {
        return new Value() {
            @Override
            public String names() {
                return names;
            }

            @Override
            public String lastNames() {
                return lastNames;
            }
        };
    }

    public interface Value{
        String names();
        String lastNames();
    }
}
