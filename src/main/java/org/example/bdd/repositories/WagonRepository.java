package org.example.bdd.repositories;

import org.example.bdd.models.WagonDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WagonRepository extends CrudRepository<WagonDAO, Integer> { }
