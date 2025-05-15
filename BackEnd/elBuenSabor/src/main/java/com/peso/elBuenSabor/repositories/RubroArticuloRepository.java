package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.RubroArticulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo, Long> {
}
