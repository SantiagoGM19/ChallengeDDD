package com.challenge.CarFactory.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.values.PieceId;
import com.challenge.CarFactory.Car.values.PieceType;

public class PieceAdded extends DomainEvent {

    private final PieceId pieceId;
    private final PieceType pieceType;

    public PieceAdded(PieceId pieceId, PieceType pieceType){
        super("carfactory.car.pieceadded");
        this.pieceId = pieceId;
        this.pieceType = pieceType;
    }

    public PieceId getPieceId() {
        return pieceId;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

}
