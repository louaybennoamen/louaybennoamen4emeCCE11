package tn.esprit.louaybennoamen4emecce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.louaybennoamen4emecce11.domaine.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
