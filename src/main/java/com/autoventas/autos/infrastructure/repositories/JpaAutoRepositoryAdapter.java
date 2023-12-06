package com.autoventas.autos.infrastructure.repositories;

import com.autoventas.autos.domain.models.Auto;
import com.autoventas.autos.domain.ports.out.AutoRepositoryPort;
import com.autoventas.autos.infrastructure.entities.AutoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class JpaAutoRepositoryAdapter implements AutoRepositoryPort {

    private final JpaAutoRepository jpaAutoRepository;

    public JpaAutoRepositoryAdapter(JpaAutoRepository jpaAutoRepository) {
        this.jpaAutoRepository = jpaAutoRepository;
    }

    @Override
    public Auto save(Auto auto) {
        AutoEntity autoEntity = AutoEntity.fromDomainModel(auto);
        AutoEntity savedAutoEntity = jpaAutoRepository.save(autoEntity);
        return savedAutoEntity.toDomainModel();
    }

    @Override
    public Optional<Auto> findById(Long id) {
        return jpaAutoRepository.findById(id).map(AutoEntity::toDomainModel);
    }

    @Override
    public List<Auto> findAll() {
        return jpaAutoRepository.findAll().stream().map(AutoEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Auto> update(Auto auto) {
        if(jpaAutoRepository.existsById(auto.getId())){
            AutoEntity autoEntity = AutoEntity.fromDomainModel(auto);
            AutoEntity updateAutoEntity = jpaAutoRepository.save(autoEntity);
            return Optional.of(updateAutoEntity.toDomainModel());
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaAutoRepository.existsById(id)){
            jpaAutoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
