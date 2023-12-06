package com.autoventas.autos.domain.ports.in;

import com.autoventas.autos.domain.models.Auto;

import java.util.Optional;

public interface DeleteAuto {
    boolean deleteAuto(Long id);
}
