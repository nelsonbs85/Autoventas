package com.autoventas.autos.application.services;

import com.autoventas.autos.domain.models.AdditionalAutoInfo;
import com.autoventas.autos.domain.models.Auto;
import com.autoventas.autos.domain.ports.in.*;
import org.antlr.v4.runtime.misc.MurmurHash;

import java.util.List;
import java.util.Optional;

public class AutoServicio implements CreateAuto, DeleteAuto, UpdateAuto, RetrieveAuto, GetAdditionalAutoInfo {

    private final CreateAuto createAuto;
    private final RetrieveAuto retrieveAuto;
    private final UpdateAuto updateAuto;
    private final DeleteAuto deleteAuto;

    private final GetAdditionalAutoInfo getAdditionalAutoInfo;

    public AutoServicio(CreateAuto createAuto, RetrieveAuto retrieveAuto, UpdateAuto updateAuto,
                        DeleteAuto deleteAuto,
                        GetAdditionalAutoInfo getAdditionalAutoInfo) {
        this.createAuto = createAuto;
        this.retrieveAuto = retrieveAuto;
        this.updateAuto = updateAuto;
        this.deleteAuto = deleteAuto;
        this.getAdditionalAutoInfo = getAdditionalAutoInfo;
    }

    @Override
    public Auto createAuto(Auto auto) {
        return createAuto.createAuto(auto);
    }

    @Override
    public boolean deleteAuto(Long id) {
        return deleteAuto.deleteAuto(id);
    }

    @Override
    public AdditionalAutoInfo getAdditionalAutoInfo(Long id) {
        return getAdditionalAutoInfo.getAdditionalAutoInfo(id);
    }

    @Override
    public Optional<Auto> getAuto(Long id) {
        return retrieveAuto.getAuto(id);
    }
    @Override
    public Optional<Auto> updateAuto(Long id, Auto updateAuto) {
        return this.updateAuto.updateAuto(id, updateAuto);
    }
    @Override
    public List<Auto> getAllAutos() {
        return retrieveAuto.getAllAutos();
    }


}
