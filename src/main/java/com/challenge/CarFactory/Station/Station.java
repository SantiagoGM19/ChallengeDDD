package com.challenge.CarFactory.Station;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.Car;
import com.challenge.CarFactory.Car.values.AssemblyReportId;
import com.challenge.CarFactory.Car.values.CarId;
import com.challenge.CarFactory.Car.values.Manufacturer;
import com.challenge.CarFactory.Station.events.*;
import com.challenge.CarFactory.Station.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Station extends AggregateEvent<StationId> {

    protected StationManagerId stationManagerId;
    protected DayReportId dayReportId;
    protected Set<Employee> employees;
    protected Set<Car> cars;
    protected Type type;

    public Station(StationId entityId, StationManagerId stationManagerId, DayReportId dayReportId, Type type) {
        super(entityId);
        appendChange(new StationCreated(stationManagerId, dayReportId, type)).apply();
    }

    public void addStationManagerId(StationManagerId stationManagerId){
        Objects.requireNonNull(stationManagerId, "The station manager id can not be null");
        appendChange(new StationManagerIdAdded(stationManagerId)).apply();
    }

    public void addDayReportId(DayReportId dayReportId){
        Objects.requireNonNull(dayReportId, "The day report id can not be null");
        appendChange(new DayReportIdAdded(dayReportId)).apply();
    }

    public void addEmployee(EmployeeId entityId, Name name, Identification identification, JobTitle jobTitle){
        Objects.requireNonNull(entityId, "The employee id can not be null");
        Objects.requireNonNull(name, "The name can not be null");
        Objects.requireNonNull(identification, "The identification can not be null");
        Objects.requireNonNull(jobTitle, "The job tilte of the employee can not be null");
        appendChange(new EmployeeAdded(entityId, name, identification, jobTitle)).apply();
    }

    public void addCar(CarId entityId, AssemblyReportId assemblyReportId, Manufacturer manufacturer){
        Objects.requireNonNull(entityId, "The employee id can not be null");
        Objects.requireNonNull(assemblyReportId, "The assembly report id can not be null");
        Objects.requireNonNull(manufacturer, "The manufacturer can not be null");
        appendChange(new CarAdded(entityId, assemblyReportId, manufacturer)).apply();
    }

    public void changeEmployeeJobTitle(EmployeeId entityId, JobTitle jobTitle){
        Objects.requireNonNull(entityId, "The employee id can not be null");
        Objects.requireNonNull(jobTitle, "The job tilte of the employee can not be null");
        appendChange(new EmployeeJobTitleChanged(entityId, jobTitle)).apply();
    }

    public void changeShiftStationManager(StationManagerId entityId, Shift shift){
        Objects.requireNonNull(entityId, "The employee id can not be null");
        Objects.requireNonNull(shift, "The shift can not be null");
        appendChange(new ShiftStationManagerChanged(entityId, shift)).apply();
    }

    public Optional<Employee> getEmployeeById(EmployeeId entityId){
        return employees
                .stream()
                .filter(employee -> employee.identity().equals(entityId))
                .findFirst();
    }

    public Optional<Car> getCarById(CarId entityId){
        return cars
                .stream()
                .filter(car -> car.identity().equals(entityId))
                .findFirst();
    }

    public StationManagerId getStationManagerId() {
        return stationManagerId;
    }

    public DayReportId getDayReportId() {
        return dayReportId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Type getType() {
        return type;
    }
}
