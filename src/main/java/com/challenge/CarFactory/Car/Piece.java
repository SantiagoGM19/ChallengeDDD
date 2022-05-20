package com.challenge.CarFactory.Car;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.Car.values.PieceId;

public class Piece extends Entity<PieceId> {
    public Piece(PieceId entityId) {
        super(entityId);
    }
}
