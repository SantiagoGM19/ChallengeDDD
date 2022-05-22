package com.challenge.CarFactory.domain.Station;

import co.com.sofka.domain.generic.EventChange;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Station.events.*;

import java.util.HashSet;
import java.util.Optional;

public class StationChange extends EventChange {
    public StationChange(Station station) {

        apply((StationCreated event) -> {
            station.type = event.getType();
            station.cars = new HashSet<>();
            station.employees = new HashSet<>();
        });

        apply((CarAdded event) -> {
            station.cars.add(new Car(
                    event.getCarId(),
                    event.getManufacturer()
            ));
        });

        apply((DayReportIdAdded event) -> {
            station.dayReportId = event.getDayReportId();
        });

        apply((EmployeeAdded event) -> {
            station.employees.add(new Employee(
                    event.getEmployeeId(),
                    event.getName(),
                    event.getIdentification(),
                    event.getJobTitle()
            ));
        });

        apply((EmployeeJobTitleChanged event) -> {
            Optional<Employee> optional_employee = station.getEmployeeById(event.getEmployeeId());
            if(optional_employee.isEmpty()){
                throw new IllegalArgumentException("There is not any employee with that id");
            }
            Employee employee = optional_employee.get();
            employee.updateJobTitle(event.getJobTitle());
        });

        apply((ShiftStationManagerChanged event) -> {
            StationManager stationManager = station.getStationManager();
            stationManager.updateShift(event.getShift());
        });

        apply((StationManagerAdded event) -> {
            station.stationManager = new StationManager(
                    event.getStationManagerId(),
                    event.getName(),
                    event.getIdentification(),
                    event.getShift()
            );
        });

        apply((StationAdminNotified event) -> {
            station.message = event.getMessage();
        });
    }
}
