package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.PieceId;
import com.challenge.CarFactory.domain.Car.values.PieceType;

public class AddPiece extends Command {

    private final CarId carId;
    private final PieceId entityId;
    private final PieceType pieceType;

    public AddPiece(CarId carId, PieceId entityId, PieceType pieceType) {
        this.carId = carId;
        this.entityId = entityId;
        this.pieceType = pieceType;
    }

    public CarId getCarId(){return carId;}

    public PieceId getEntityId() {
        return entityId;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
