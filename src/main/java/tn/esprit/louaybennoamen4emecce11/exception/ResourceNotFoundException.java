package tn.esprit.louaybennoamen4emecce11.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " introuvable avec l'identifiant " + id);
    }
}
