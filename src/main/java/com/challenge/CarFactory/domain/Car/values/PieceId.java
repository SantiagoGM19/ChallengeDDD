package com.challenge.CarFactory.domain.Car.values;

import co.com.sofka.domain.generic.Identity;

public class PieceId extends Identity {

    public PieceId(){

    }

    private PieceId(String id){
        super(id);
    }

    public static PieceId of(String id){
        return new PieceId(id);
    }
}
