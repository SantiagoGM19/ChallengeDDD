package com.challenge.CarFactory.domain.Car;

import co.com.sofka.domain.generic.EventChange;
import com.challenge.CarFactory.domain.Car.events.*;

import java.util.HashSet;
import java.util.Optional;

public class CarChange extends EventChange {
    public CarChange(Car car){
        apply((CarCreated event) -> {
            car.pieces = new HashSet<>();
            car.processes = new HashSet<>();
            car.manufacturer = event.getManufacturer();
        });

        apply((PieceAdded event) -> {
            car.pieces.add(new Piece(
                    event.getPieceId(),
                    event.getPieceType()
            ));
        });

        apply((ProcessAdded event) -> {
            var processAmount = car.processes.size();
            if(processAmount == 4){
                throw new IllegalArgumentException("you can not add more processes to this car, It has only 4");
            }
            car.processes.add(new Process(
                    event.getProcessId(),
                    event.getProcessType(),
                    event.getStatus(),
                    event.getDescription()
            ));
        });

        apply((AssemblyReportIdAdded event) -> {
            car.assemblyReportId = event.getAssemblyReportId();
        });

        apply((PieceChanged event) -> {
            Optional<Piece> optional_piece = car.getPieceById(event.getPieceId());
            if(optional_piece.isEmpty()){
                throw new IllegalArgumentException("There is not any piece with that id");
            }
            Piece piece = optional_piece.get();
            piece.updateTypePiece(event.getPieceType());

        });

        apply((ManufacturerUpdated event) -> {
            car.manufacturer = event.getManufacturer();
        });

        apply((StatusProcessChanged event) -> {
            Optional<Process> optional_process = car.getProcessById(event.getProcessId());
            if(optional_process.isEmpty()){
                throw new IllegalArgumentException("There is not any process with that id");
            }
            Process process = optional_process.get();
            process.cangeStatus(event.getStatus());
        });
    }
}
