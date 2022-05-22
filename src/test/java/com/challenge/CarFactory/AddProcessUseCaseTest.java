package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.commands.AddProcess;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.events.ProcessAdded;
import com.challenge.CarFactory.domain.Car.values.*;
import com.challenge.CarFactory.usecase.AddProcessUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddProcessUseCaseTest {

    private final String ROOTID = "MAZ-12";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addProcess(){
        var command = new AddProcess(
                CarId.of(ROOTID),
                ProcessId.of("P01"),
                new ProcessType("weld", "first put then weld"),
                new Status(true),
                new Description("The process had some issues but is done")
        );
        var useCase = new AddProcessUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new CarCreated(
                        new Manufacturer("Mazda")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the process made to the car"))
                .getDomainEvents();

        var event = (ProcessAdded)events.get(0);
        Assertions.assertEquals(command.getEntityId().value(), event.getProcessId().value());
        Assertions.assertEquals(command.getProcessType().value().type(), event.getProcessType().value().type());
        Assertions.assertEquals(command.getProcessType().value().steps(), event.getProcessType().value().steps());
        Assertions.assertEquals(command.getStatus().value(), event.getStatus().value());
        Assertions.assertEquals(command.getDescription().value(), event.getDescription().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
