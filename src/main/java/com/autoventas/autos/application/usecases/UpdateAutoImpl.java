package com.autoventas.autos.application.usecases;

import com.autoventas.autos.domain.models.Auto;
import com.autoventas.autos.domain.ports.in.UpdateAuto;
import com.autoventas.autos.domain.ports.out.AutoRepositoryPort;

import java.util.Optional;

public class UpdateAutoImpl implements UpdateAuto {
    private final AutoRepositoryPort autoRepositoryPort;

    public UpdateAutoImpl(AutoRepositoryPort autoRepositoryPort) {
        this.autoRepositoryPort = autoRepositoryPort;
    }

    @Override
    public Optional<Auto> updateAuto(Long id, Auto updateAuto) {
        return autoRepositoryPort.update(updateAuto);
    }
}
