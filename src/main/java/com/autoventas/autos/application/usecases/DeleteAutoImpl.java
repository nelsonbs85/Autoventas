package com.autoventas.autos.application.usecases;

import com.autoventas.autos.domain.ports.in.DeleteAuto;
import com.autoventas.autos.domain.ports.out.AutoRepositoryPort;

public class DeleteAutoImpl implements DeleteAuto {
    private final AutoRepositoryPort autoRepositoryPort;

    public DeleteAutoImpl(AutoRepositoryPort autoRepositoryPort) {
        this.autoRepositoryPort = autoRepositoryPort;
    }


    @Override
    public boolean deleteAuto(Long id) {
        return autoRepositoryPort.deleteById(id);
    }
}
