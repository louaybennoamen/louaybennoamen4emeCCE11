package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Agence;

import java.util.List;

public interface IAgenceService {
    Agence create(Agence agence);

    Agence update(Long id, Agence agence);

    void deleteById(Long id);

    Agence findById(Long id);

    List<Agence> findAll();
}
