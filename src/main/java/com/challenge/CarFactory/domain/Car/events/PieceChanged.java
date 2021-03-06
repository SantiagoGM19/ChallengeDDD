package com.challenge.CarFactory.domain.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.values.PieceId;
import com.challenge.CarFactory.domain.Car.values.PieceType;

public class PieceChanged extends DomainEvent {

    private final PieceId pieceId;
    private final PieceType pieceType;

    public PieceChanged(PieceId pieceId, PieceType pieceType){
        super("carfactory.car.piecechanged");
        this.pieceId = pieceId;
        this.pieceType = pieceType;
    }

    public PieceId getPieceId(){
        return pieceId;
    }

    public PieceType getPieceType(){return pieceType;}
}
