package com.autoventas.autos.domain.ports.in;

import com.autoventas.autos.domain.models.Auto;

public interface CreateAuto {
    Auto createAuto(Auto auto);
}
