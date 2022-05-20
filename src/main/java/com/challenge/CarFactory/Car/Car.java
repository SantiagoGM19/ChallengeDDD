package com.challenge.CarFactory.Car;

import co.com.sofka.domain.generic.AggregateEvent;
import com.challenge.CarFactory.Car.values.CarId;

public class Car extends AggregateEvent<CarId> {
    public Car(CarId entityId) {
        super(entityId);
    }
}
