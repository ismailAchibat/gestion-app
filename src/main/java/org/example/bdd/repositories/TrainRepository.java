package org.example.bdd.repositories;

import org.example.bdd.models.TrainDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends CrudRepository<TrainDAO, Long> {
TrainDAO findByMatricule (String matricule);
}
