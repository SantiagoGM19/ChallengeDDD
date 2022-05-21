package com.challenge.CarFactory.Station.values;

import co.com.sofka.domain.generic.ValueObject;

public class Name implements ValueObject<Name.Value> {


    @Override
    public Name.Value value() {
        return null;
    }

    public interface Value{
        String names();
        String lastNames();
    }
}
