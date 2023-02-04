package com.adr.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adr.ad.model.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long>{

}
