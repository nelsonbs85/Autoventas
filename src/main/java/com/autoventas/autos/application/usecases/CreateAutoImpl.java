package com.autoventas.autos.application.usecases;

import com.autoventas.autos.domain.models.Auto;
import com.autoventas.autos.domain.ports.in.CreateAuto;
import com.autoventas.autos.domain.ports.out.AutoRepositoryPort;

public class CreateAutoImpl implements CreateAuto {
    private final AutoRepositoryPort autoRepositoryPort;


    public CreateAutoImpl(AutoRepositoryPort autoRepositoryPort) {
        this.autoRepositoryPort = autoRepositoryPort;
    }

    @Override
    public Auto createAuto(Auto auto) {
        return autoRepositoryPort.save(auto);
    }
}
