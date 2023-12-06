package com.autoventas.autos.domain.ports.out;

import com.autoventas.autos.domain.models.Auto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AutoRepositoryPort {
    Auto save(Auto auto);
    Optional<Auto> findById(Long id);
    List<Auto> findAll();
    Optional<Auto> update(Auto auto);

    boolean deleteById(Long id);

}
