package com.autoventas.autos.domain.ports.out;

import com.autoventas.autos.domain.models.AdditionalAutoInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalServicePort {
        AdditionalAutoInfo getAdditionalAutoInfo(Long AutoId);
}
