package org.example.bdd.repositories;

import org.example.bdd.models.ReservationDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<ReservationDAO, Integer> {
    List<ReservationDAO> findByHoraire_Id(Integer horaireId);
}
