package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Car.commands.AddAssemblyReportId;
import com.challenge.CarFactory.domain.Car.commands.AddPiece;
import com.challenge.CarFactory.domain.Car.events.AssemblyReportIdAdded;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.events.PieceAdded;
import com.challenge.CarFactory.domain.Car.values.*;
import com.challenge.CarFactory.usecase.AddAssemblyReportIdUseCase;
import com.challenge.CarFactory.usecase.AddPieceUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddPieceUseCaseTest {

    private final String ROOTID = "MAZ-12";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPiece(){
        var command = new AddPiece(
                CarId.of(ROOTID),
                PieceId.of("PIECE01"),
                new PieceType("tire", 3)
        );
        var useCase = new AddPieceUseCase();

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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the piece to the car"))
                .getDomainEvents();

        var event = (PieceAdded)events.get(0);
        Assertions.assertEquals(command.getEntityId().value(), event.getPieceId().value());
        Assertions.assertEquals(command.getPieceType().value().type(), event.getPieceType().value().type());
        Assertions.assertEquals(command.getPieceType().value().quality(), event.getPieceType().value().quality());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
