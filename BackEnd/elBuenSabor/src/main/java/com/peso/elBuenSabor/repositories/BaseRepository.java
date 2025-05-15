package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E,ID> {
}
