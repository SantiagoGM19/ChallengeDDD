package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Station.commands.AddDayReportId;
import com.challenge.CarFactory.domain.Station.commands.AddEmployee;
import com.challenge.CarFactory.domain.Station.events.DayReportIdAdded;
import com.challenge.CarFactory.domain.Station.events.EmployeeAdded;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.*;
import com.challenge.CarFactory.usecase.AddDayReportIdUseCase;
import com.challenge.CarFactory.usecase.AddEmployeeUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddEmployeeUseCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addEmployee(){
        var command = new AddEmployee(
                StationId.of(ROOTID),
                EmployeeId.of("E01"),
                new Name("Richard", "Brown"),
                new Identification("1022384755"),
                new JobTitle("welder")
        );

        var useCase = new AddEmployeeUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new StationCreated(
                        new Type("external assembly")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the employee to the station"))
                .getDomainEvents();

        var event = (EmployeeAdded)events.get(0);
        Assertions.assertEquals(command.getEmployeeId().value(), event.getEmployeeId().value());
        Assertions.assertEquals(command.getName().value().names(), event.getName().value().names());
        Assertions.assertEquals(command.getName().value().lastNames(), event.getName().value().lastNames());
        Assertions.assertEquals(command.getIdentification().value(), event.getIdentification().value());
        Assertions.assertEquals(command.getJobTitle().value(), event.getJobTitle().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
