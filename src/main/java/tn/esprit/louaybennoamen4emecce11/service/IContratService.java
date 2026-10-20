package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Contrat;

import java.util.List;

public interface IContratService {
    Contrat create(Contrat contrat);

    Contrat update(Long id, Contrat contrat);

    void deleteById(Long id);

    Contrat findById(Long id);

    List<Contrat> findAll();
}
