package org.example.bdd.repositories;

import org.example.bdd.models.CheminDeFerDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheminDeFerRepository extends CrudRepository<CheminDeFerDAO, Long> {
    List<CheminDeFerDAO> findByGareDepart_Id(Long gareDepartId);
    List<CheminDeFerDAO> findByGareArrivee_Id(Long gareArriveeId);
}
