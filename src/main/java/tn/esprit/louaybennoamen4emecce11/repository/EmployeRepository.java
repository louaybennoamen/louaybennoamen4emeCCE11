package tn.esprit.louaybennoamen4emecce11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.louaybennoamen4emecce11.domaine.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
