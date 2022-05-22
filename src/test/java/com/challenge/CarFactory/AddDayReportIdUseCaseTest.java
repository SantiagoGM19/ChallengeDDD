package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;
import com.challenge.CarFactory.domain.Station.commands.AddCar;
import com.challenge.CarFactory.domain.Station.commands.AddDayReportId;
import com.challenge.CarFactory.domain.Station.events.CarAdded;
import com.challenge.CarFactory.domain.Station.events.DayReportIdAdded;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.DayReportId;
import com.challenge.CarFactory.domain.Station.values.StationId;
import com.challenge.CarFactory.domain.Station.values.Type;
import com.challenge.CarFactory.usecase.AddCarUseCase;
import com.challenge.CarFactory.usecase.AddDayReportIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddDayReportIdUseCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addReportId(){
        var command = new AddDayReportId(
                StationId.of(ROOTID),
                DayReportId.of("D1")
        );

        var useCase = new AddDayReportIdUseCase();

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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the day report id to the station"))
                .getDomainEvents();

        var event = (DayReportIdAdded)events.get(0);
        Assertions.assertEquals(command.getDayReportId().value(), event.getDayReportId().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
