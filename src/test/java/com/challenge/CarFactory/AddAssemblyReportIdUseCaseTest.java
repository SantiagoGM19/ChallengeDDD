package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.commands.AddAssemblyReportId;
import com.challenge.CarFactory.domain.Car.events.AssemblyReportIdAdded;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;
import com.challenge.CarFactory.usecase.AddAssemblyReportIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddAssemblyReportIdUseCaseTest {

    private final String ROOTID = "MAZ-12";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addAssemblyReportId(){
        var command = new AddAssemblyReportId(
                CarId.of(ROOTID),
                AssemblyReportId.of("ASY-01")
        );
        var useCase = new AddAssemblyReportIdUseCase();

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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the assembly report id"))
                .getDomainEvents();

        var event = (AssemblyReportIdAdded)events.get(0);
        Assertions.assertEquals(command.getAssemblyReportId().value(), event.getAssemblyReportId().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
