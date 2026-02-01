package org.example.bdd.repositories;

import org.example.bdd.models.UsagerDAO;
import org.springframework.data.repository.CrudRepository;

public interface UsagerRepository extends CrudRepository<UsagerDAO, Integer> { }
