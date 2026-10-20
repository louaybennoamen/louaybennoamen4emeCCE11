package tn.esprit.louaybennoamen4emecce11.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.louaybennoamen4emecce11.domaine.Vehicule;
import tn.esprit.louaybennoamen4emecce11.domaine.Agence;
import tn.esprit.louaybennoamen4emecce11.repository.AgenceRepository;
import tn.esprit.louaybennoamen4emecce11.exception.ResourceNotFoundException;
import tn.esprit.louaybennoamen4emecce11.repository.VehiculeRepository;
import tn.esprit.louaybennoamen4emecce11.service.IVehiculeService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Vehicule create(Vehicule vehicule) {
        vehicule.setIdVehicule(null); // l'identifiant est toujours généré par la base
        vehicule.setAgence(resolveAgence(vehicule.getAgence()));
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existing = vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
        existing.setImmatriculation(vehicule.getImmatriculation());
        existing.setMarque(vehicule.getMarque());
        existing.setModele(vehicule.getModele());
        existing.setCategorie(vehicule.getCategorie());
        existing.setTarifJournalier(vehicule.getTarifJournalier());
        existing.setStatut(vehicule.getStatut());
        existing.setAgence(resolveAgence(vehicule.getAgence()));
        return vehiculeRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        vehiculeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    /** Vérifie que l'agence référencée existe (sinon 404) et renvoie l'entité gérée. */
    private Agence resolveAgence(Agence agence) {
        if (agence == null) {
            return null;
        }
        if (agence.getIdAgence() == null) {
            throw new IllegalArgumentException("L'agence doit être référencée par son idAgence");
        }
        return agenceRepository.findById(agence.getIdAgence())
                .orElseThrow(() -> new ResourceNotFoundException("Agence", agence.getIdAgence()));
    }
}
