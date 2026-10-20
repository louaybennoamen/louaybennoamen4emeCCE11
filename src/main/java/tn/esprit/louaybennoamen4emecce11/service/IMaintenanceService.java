package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance create(Maintenance maintenance);

    Maintenance update(Long id, Maintenance maintenance);

    void deleteById(Long id);

    Maintenance findById(Long id);

    List<Maintenance> findAll();
}
