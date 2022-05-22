package com.challenge.CarFactory.domain.Car;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.domain.Car.values.PieceId;
import com.challenge.CarFactory.domain.Car.values.PieceType;

import java.util.Objects;

public class Piece extends Entity<PieceId> {

    private PieceType pieceType;

    public Piece(PieceId entityId, PieceType pieceType) {
        super(entityId);
        this.pieceType = pieceType;
    }

    public void updateTypePiece(PieceType pieceType){
        this.pieceType = Objects.requireNonNull(pieceType, "The piece type is null, It is required to add one");
    }

    public PieceType typePiece(){
        return pieceType;
    }

}
