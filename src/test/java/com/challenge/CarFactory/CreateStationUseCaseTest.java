package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Station.commands.CreateStation;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.DayReportId;
import com.challenge.CarFactory.domain.Station.values.StationId;
import com.challenge.CarFactory.domain.Station.values.Type;
import com.challenge.CarFactory.usecase.CreateStationUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateStationUseCaseTest {

    @Test
    void createStation(){
        //Arrange
        var command = new CreateStation(
                StationId.of("S1"),
                DayReportId.of("DR1"),
                new Type("external assembly")
        );

        var useCase = new CreateStationUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating the station"))
                .getDomainEvents();

        //Assert
        var event = (StationCreated)events.get(0);
        Assertions.assertEquals(command.getDayReportId().value(), event.getDayReportId().value());
        Assertions.assertEquals(command.getType().value(), event.getType().value());
    }
}
