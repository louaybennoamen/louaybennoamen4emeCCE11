package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement create(Equipement equipement);

    Equipement update(Long id, Equipement equipement);

    void deleteById(Long id);

    Equipement findById(Long id);

    List<Equipement> findAll();
}
