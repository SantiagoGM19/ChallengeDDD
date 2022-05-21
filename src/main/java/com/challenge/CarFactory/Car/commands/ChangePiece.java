package com.challenge.CarFactory.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Car.Piece;
import com.challenge.CarFactory.Car.values.PieceId;
import com.challenge.CarFactory.Car.values.PieceType;

public class ChangePiece extends Command {

    private final PieceId entityId;
    private final PieceType pieceType;

    public ChangePiece(PieceId entityId, PieceType pieceType){
        this.entityId = entityId;
        this.pieceType = pieceType;
    }

    public PieceId getEntityId() {
        return entityId;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
