package org.example.bdd.repositories;

import org.example.bdd.models.HoraireDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoraireRepository extends CrudRepository<HoraireDAO, Integer> {
    List<HoraireDAO> findByTrajet_GareDepart_NomAndTrajet_GareArrivee_Nom(String nomGareDepart, String nomGareArrivee);
}
