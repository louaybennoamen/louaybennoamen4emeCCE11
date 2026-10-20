package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation create(Reservation reservation);

    Reservation update(Long id, Reservation reservation);

    void deleteById(Long id);

    Reservation findById(Long id);

    List<Reservation> findAll();
}
