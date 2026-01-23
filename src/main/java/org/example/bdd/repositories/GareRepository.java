package org.example.bdd.repositories;

import org.example.bdd.models.GareDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GareRepository extends CrudRepository<GareDAO, Integer> {
GareDAO findFirstByNom(String nom);
}
