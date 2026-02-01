package org.example.bdd.repositories;

import org.example.bdd.models.TrajetDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajetRepository extends CrudRepository<TrajetDAO, Integer> {
    List<TrajetDAO> findByGareDepart_NomAndGareArrivee_Nom(String nomGareDepart, String nomGareArrivee);
}
