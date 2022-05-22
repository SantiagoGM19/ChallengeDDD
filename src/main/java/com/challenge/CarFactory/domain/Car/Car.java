package com.challenge.CarFactory.domain.Car;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.events.*;
import com.challenge.CarFactory.domain.Car.values.*;
import com.challenge.CarFactory.domain.Station.events.StationAdminNotified;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Car extends AggregateEvent<CarId> {

    protected Set<Piece> pieces;
    protected Set<Process> processes;
    protected AssemblyReportId assemblyReportId;
    protected Manufacturer manufacturer;

    public Car(CarId entityId, Manufacturer manufacturer) {
        super(entityId);
        appendChange(new  CarCreated(manufacturer)).apply();
    }

    private Car(CarId entityId){
        super(entityId);
        subscribe(new CarChange(this));
    }

    public static Car from(CarId carId, List<DomainEvent> events){
        var car = new Car(carId);
        events.forEach(car::applyEvent);
        return car;
    }

    public void addPiece(PieceId entityId, PieceType pieceType){
        Objects.requireNonNull(entityId, "The piece can not have a null id");
        Objects.requireNonNull(pieceType, "piece type null, it is required");
        appendChange(new PieceAdded(entityId, pieceType)).apply();
    }

    public void addProcess(ProcessId entityId, ProcessType processType, Status status, Description description){
        Objects.requireNonNull(entityId, "The process can not have a null id");
        Objects.requireNonNull(processType, "Process type null, it is required");
        Objects.requireNonNull(status, "Status null, the process must have it");
        Objects.requireNonNull(description, "Description null, the process must have it");
        appendChange(new ProcessAdded(entityId, processType, status, description)).apply();
    }

    public void addAssemblyReportId(AssemblyReportId entityId){
        Objects.requireNonNull(entityId, "the assembly report needs an defined id");
        appendChange(new AssemblyReportIdAdded(entityId)).apply();
    }

    public void changePiece(PieceId entityId, PieceType pieceType){
        Objects.requireNonNull(entityId, "Piece id needed to change it");
        Objects.requireNonNull(pieceType, "Piece type null, it is required");
        appendChange(new PieceChanged(entityId, pieceType)).apply();
    }

    public void updateManufacturer(Manufacturer manufacturer){
        Objects.requireNonNull(manufacturer, "Manufacturer needed to update");
        appendChange(new ManufacturerUpdated(manufacturer)).apply();
    }

    public void changeStatusProcess(ProcessId entityId, Status status){
        Objects.requireNonNull(entityId, "The process id given is null, it is required");
        Objects.requireNonNull(status, "The status given is null, it is required");
        appendChange(new StatusProcessChanged(entityId, status)).apply();
    }

    public void notifyAssemblyAdmin(String message){
        Objects.requireNonNull(message, "The message for the notify can not be null");
        appendChange(new AssemblyAdminNotified(message)).apply();
    }

    public Optional<Piece> getPieceById(PieceId entityId){
        return pieces
                .stream()
                .filter(piece -> piece.identity().equals(entityId))
                .findFirst();
    }

    public Optional<Process> getProcessById(ProcessId entityId){
        return processes
                .stream()
                .filter(process -> process.identity().equals(entityId))
                .findFirst();
    }

    public Set<Piece> pieces() {
        return pieces;
    }

    public Set<Process> processes() {
        return processes;
    }

    public AssemblyReportId assemblyReportId() {
        return assemblyReportId;
    }

    public Manufacturer manufacturer() {
        return manufacturer;
    }
}
