package com.challenge.CarFactory.Station;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.Car;
import com.challenge.CarFactory.Car.CarChange;
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

    protected StationManager stationManager;
    protected DayReportId dayReportId;
    protected Set<Employee> employees;
    protected Set<Car> cars;
    protected Type type;

    public Station(StationId entityId, StationManager stationManager, DayReportId dayReportId, Type type) {
        super(entityId);
        appendChange(new StationCreated(stationManager, dayReportId, type)).apply();
    }

    private Station(StationId entityId){
        super(entityId);
        subscribe(new StationChange(this));
    }

    public static Station from(StationId stationId, List<DomainEvent> events){
        var station = new Station(stationId);
        events.forEach(station::applyEvent);
        return station;
    }

    public void addStationManager(StationManagerId entityId, Name name, Identification identification, Shift shift){
        Objects.requireNonNull(entityId, "The station manager id can not be null");
        Objects.requireNonNull(name, "The name can not be null");
        Objects.requireNonNull(identification, "The identification can not be null");
        Objects.requireNonNull(shift, "The shift can not be null");
        appendChange(new StationManagerAdded(entityId, name, identification, shift)).apply();
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

    public void changeShiftStationManager(Shift shift){
        Objects.requireNonNull(shift, "The shift can not be null");
        appendChange(new ShiftStationManagerChanged(shift)).apply();
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

    public StationManager getStationManager() {
        return stationManager;
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
