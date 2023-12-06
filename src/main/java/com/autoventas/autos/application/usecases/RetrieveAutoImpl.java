package com.autoventas.autos.application.usecases;

import com.autoventas.autos.domain.models.Auto;
import com.autoventas.autos.domain.ports.in.RetrieveAuto;
import com.autoventas.autos.domain.ports.out.AutoRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveAutoImpl implements RetrieveAuto {

    private final AutoRepositoryPort autoRepositoryPort;

    public RetrieveAutoImpl(AutoRepositoryPort autoRepositoryPort) {
        this.autoRepositoryPort = autoRepositoryPort;
    }

    @Override
    public Optional<Auto> getAuto(Long id) {
        return autoRepositoryPort.findById(id);
    }

    @Override
    public List<Auto> getAllAutos() {
        return autoRepositoryPort.findAll();
    }
}
