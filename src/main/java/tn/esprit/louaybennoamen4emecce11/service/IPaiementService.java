package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement create(Paiement paiement);

    Paiement update(Long id, Paiement paiement);

    void deleteById(Long id);

    Paiement findById(Long id);

    List<Paiement> findAll();
}
