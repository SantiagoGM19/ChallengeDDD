package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.commands.AddProcess;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.events.ProcessAdded;
import com.challenge.CarFactory.domain.Car.values.*;
import com.challenge.CarFactory.domain.Station.commands.AddCar;
import com.challenge.CarFactory.domain.Station.events.CarAdded;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.DayReportId;
import com.challenge.CarFactory.domain.Station.values.StationId;
import com.challenge.CarFactory.domain.Station.values.Type;
import com.challenge.CarFactory.usecase.AddCarUseCase;
import com.challenge.CarFactory.usecase.AddProcessUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddCarUseCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addCar(){
        var command = new AddCar(
                StationId.of(ROOTID),
                CarId.of("MAZ-12"),
                AssemblyReportId.of("ASY-01"),
                new Manufacturer("Mazda")
        );

        var useCase = new AddCarUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new StationCreated(
                        DayReportId.of("D1"),
                        new Type("external assembly")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the car to the station"))
                .getDomainEvents();

        var event = (CarAdded)events.get(0);
        Assertions.assertEquals(command.getCarId().value(), event.getCarId().value());
        Assertions.assertEquals(command.getAssemblyReportId().value(), event.getAssemblyReportId().value());
        Assertions.assertEquals(command.getManufacturer().value(), event.getManufacturer().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
