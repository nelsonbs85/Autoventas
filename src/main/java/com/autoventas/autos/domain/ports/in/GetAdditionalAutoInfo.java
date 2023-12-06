package com.autoventas.autos.domain.ports.in;

import com.autoventas.autos.domain.models.AdditionalAutoInfo;

public interface GetAdditionalAutoInfo {
    AdditionalAutoInfo getAdditionalAutoInfo(Long id);
}
