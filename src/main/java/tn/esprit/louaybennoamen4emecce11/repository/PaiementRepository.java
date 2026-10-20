package tn.esprit.louaybennoamen4emecce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.louaybennoamen4emecce11.domaine.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
