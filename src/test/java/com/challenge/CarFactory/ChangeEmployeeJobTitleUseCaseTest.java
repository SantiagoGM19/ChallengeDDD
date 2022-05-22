package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Station.commands.AddEmployee;
import com.challenge.CarFactory.domain.Station.commands.ChangeEmployeeJobTitle;
import com.challenge.CarFactory.domain.Station.events.EmployeeAdded;
import com.challenge.CarFactory.domain.Station.events.EmployeeJobTitleChanged;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.*;
import com.challenge.CarFactory.usecase.AddEmployeeUseCase;
import com.challenge.CarFactory.usecase.ChangeEmployeeJobTitleUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ChangeEmployeeJobTitleUseCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeEmployeeJobTitle(){
        var command = new ChangeEmployeeJobTitle(
                StationId.of(ROOTID),
                EmployeeId.of("E01"),
                new JobTitle("repairman")
        );

        var useCase = new ChangeEmployeeJobTitleUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new StationCreated(
                        new Type("external assembly")
                ),
                new EmployeeAdded(
                        EmployeeId.of("E01"),
                        new Name("Richard", "Brown"),
                        new Identification("1022384755"),
                        new JobTitle("welder")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong changing the job tile"))
                .getDomainEvents();

        var event = (EmployeeJobTitleChanged)events.get(0);
        Assertions.assertEquals(command.getEmployeeId().value(), event.getEmployeeId().value());
        Assertions.assertEquals(command.getJobTitle().value(), event.getJobTitle().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
