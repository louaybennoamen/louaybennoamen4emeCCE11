# Atelier 5 — 3 contrôleurs REST (Agence, Véhicule, Contrat)

## Contrôleurs
| Contrôleur | Route | Service |
|---|---|---|
| AgenceController | /api/agences | IAgenceService |
| VehiculeController | /api/vehicules | IVehiculeService |
| ContratController | /api/contrats (cascade vers Paiement) | IContratService |

## Modifications de cette version
- Ajout de `ContratController` (CRUD, injection par l'interface `IContratService`).
- `Contrat.paiements` : `@JsonManagedReference("contrat-paiements")` ; `Paiement.contrat` : `@JsonBackReference("contrat-paiements")` (TP section 1.4).
- `Agence.vehicules` : `@JsonIgnore` (au lieu de `@JsonBackReference`).
- Validations ajoutées sur `Contrat` et `Paiement` (400 si montant négatif, date absente...).
- `ContratServiceImpl.create` : un identifiant fourni dans le corps donne 400 (comme demandé à l'étape 4 du TP).

## Lancer
1. Démarrer MySQL (XAMPP), mot de passe root vide.
2. Reload Maven, JDK 17+, puis Run `Louaybennoamen4emeCce11Application`.
3. Swagger : http://localhost:8081/swagger-ui.html

## Postman
Importer `docs/Location-vehicules.postman_collection.json` puis **Run collection** (dans l'ordre).
