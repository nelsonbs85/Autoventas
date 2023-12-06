package com.autoventas.autos.domain.ports.in;

import com.autoventas.autos.domain.models.Auto;

import java.util.List;
import java.util.Optional;

public interface RetrieveAuto {
    Optional<Auto> getAuto(Long id);
    List<Auto> getAllAutos();

}
