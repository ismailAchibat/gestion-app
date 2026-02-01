package org.example.bdd.repositories;

import org.example.bdd.models.CheminDeFerDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheminDeFerRepository
        extends CrudRepository<CheminDeFerDAO, Integer> {

    List<CheminDeFerDAO> findByGareDepart_Id(Integer gareDepartId);
    CheminDeFerDAO findFirstByGareDepart_IdAndGareArrivee_Id(Integer departId, Integer arriveeId);

}





