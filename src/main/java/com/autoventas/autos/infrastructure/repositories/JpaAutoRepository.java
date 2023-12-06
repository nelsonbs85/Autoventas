package com.autoventas.autos.infrastructure.repositories;

import com.autoventas.autos.infrastructure.entities.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAutoRepository extends JpaRepository<AutoEntity,Long > {

}
