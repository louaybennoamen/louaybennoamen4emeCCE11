package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Employe;

import java.util.List;

public interface IEmployeService {
    Employe create(Employe employe);

    Employe update(Long id, Employe employe);

    void deleteById(Long id);

    Employe findById(Long id);

    List<Employe> findAll();
}
