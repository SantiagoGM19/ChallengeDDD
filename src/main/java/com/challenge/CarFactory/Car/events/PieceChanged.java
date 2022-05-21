package com.challenge.CarFactory.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.Piece;
import com.challenge.CarFactory.Car.values.PieceId;

public class PieceChanged extends DomainEvent {

    private final PieceId pieceId;

    public PieceChanged(PieceId pieceId){
        super("carfactory.car.piecechanged");
        this.pieceId = pieceId;
    }

    public PieceId getPieceId(){
        return pieceId;
    }
}
