package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule vehicule);

    Vehicule update(Long id, Vehicule vehicule);

    void deleteById(Long id);

    Vehicule findById(Long id);

    List<Vehicule> findAll();
}
