package com.autoventas.autos.application.usecases;

import com.autoventas.autos.domain.models.AdditionalAutoInfo;
import com.autoventas.autos.domain.ports.in.GetAdditionalAutoInfo;
import com.autoventas.autos.domain.ports.out.ExternalServicePort;

public class GetAdditionalAutoInfoImpl implements GetAdditionalAutoInfo {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalAutoInfoImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalAutoInfo getAdditionalAutoInfo(Long id) {
        return externalServicePort.getAdditionalAutoInfo(id);
    }
}
