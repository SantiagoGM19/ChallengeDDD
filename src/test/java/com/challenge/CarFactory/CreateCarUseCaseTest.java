package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.commands.CreateCar;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;
import com.challenge.CarFactory.usecase.CreateCarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCarUseCaseTest {

    @Test
    void createCar(){
        //Arrange
        var command = new CreateCar(
                CarId.of("MAZ-12"),
                new Manufacturer("Mazda")
        );

        var useCase = new CreateCarUseCase();

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating the car"))
                .getDomainEvents();

        //Assert
        var event = (CarCreated)events.get(0);
        Assertions.assertEquals(command.getManufacturer().value(), event.getManufacturer().value());
    }
}
