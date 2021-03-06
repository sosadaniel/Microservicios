package com.microservicios.examenes.repository;


import com.commons.examenes.entity.Examen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long> {

    @Query("select e from Examen e where e.nombre like %?1%")
    List<Examen> findByNombre(String term);

    @Query("select e.id from Pregunta p join p.examen e where p.id in ?1 group by e.id")
    Iterable<Long>  findExamenesIdsConRespuestasByPreguntasIds(Iterable<Long> preguntasIds);

}
