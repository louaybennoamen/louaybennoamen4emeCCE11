package tn.esprit.louaybennoamen4emecce11.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.louaybennoamen4emecce11.domaine.Contrat;
import tn.esprit.louaybennoamen4emecce11.exception.ErrorResponse;
import tn.esprit.louaybennoamen4emecce11.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
@Tag(name = "Contrats", description = "Gestion des contrats de location (avec leurs paiements en cascade)")
public class ContratController {

    private final IContratService service;

    @Operation(summary = "Créer un contrat (avec ou sans paiements imbriqués)")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides (ou identifiant fourni)",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<Contrat> create(@Valid @RequestBody Contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(contrat));
    }

    @Operation(summary = "Lister les contrats")
    @ApiResponse(responseCode = "200", description = "Liste (éventuellement vide)")
    @GetMapping
    public List<Contrat> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Consulter par identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Trouvé"),
            @ApiResponse(responseCode = "404", description = "Introuvable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public Contrat findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Modifier par identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Introuvable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public Contrat update(@PathVariable Long id, @Valid @RequestBody Contrat contrat) {
        return service.update(id, contrat);
    }

    @Operation(summary = "Supprimer par identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Supprimé"),
            @ApiResponse(responseCode = "404", description = "Introuvable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
