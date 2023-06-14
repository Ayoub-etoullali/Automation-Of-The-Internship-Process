package ma.enset.gestionStage.web;

import ma.enset.gestionStage.dtos.OffreDeStageDTO;
import ma.enset.gestionStage.dtos.OffreDeStageDetailsDTO;
import ma.enset.gestionStage.services.OffreDeStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/offre-de-stages")
@CrossOrigin(origins = "*")
public class OffreDeStageController {
    private final OffreDeStageService offreDeStageService;

    @Autowired
    public OffreDeStageController(OffreDeStageService offreDeStageService) {
        this.offreDeStageService = offreDeStageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OffreDeStageDTO>> getAllOffreDeStages() {
        List<OffreDeStageDTO> offreDeStages = offreDeStageService.getAllOffreDeStages();
        return ResponseEntity.ok(offreDeStages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreDeStageDTO> getOffreDeStageById(@PathVariable Long id) {
        OffreDeStageDTO offreDeStage = offreDeStageService.getOffreDeStageById(id);
        return ResponseEntity.ok(offreDeStage);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<OffreDeStageDetailsDTO> getOffreDeStageDetailsById(@PathVariable Long id) {
        OffreDeStageDetailsDTO offreDeStageDetails = offreDeStageService.getOffreDeStageDetailsById(id);
        return ResponseEntity.ok(offreDeStageDetails);
    }

    @PostMapping("/create")
    public ResponseEntity<OffreDeStageDTO> createOffreDeStage(@RequestBody OffreDeStageDTO offreDeStageDTO) {
        OffreDeStageDTO createdOffreDeStage = offreDeStageService.createOffreDeStage(offreDeStageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOffreDeStage);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OffreDeStageDTO> updateOffreDeStage(@PathVariable Long id, @RequestBody OffreDeStageDTO offreDeStageDTO) {
        OffreDeStageDTO updatedOffreDeStage = offreDeStageService.updateOffreDeStage(id, offreDeStageDTO);
        return ResponseEntity.ok(updatedOffreDeStage);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffreDeStage(@PathVariable Long id) {
        offreDeStageService.deleteOffreDeStage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<OffreDeStageDTO>> filterOffreDeStagesByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<OffreDeStageDTO> filteredOffreDeStages = offreDeStageService.filterOffreDeStagesByDate(date);
        return ResponseEntity.ok(filteredOffreDeStages);
    }

    @GetMapping("/search")
    public ResponseEntity<List<OffreDeStageDTO>> searchOffreDeStages(@RequestParam("keyword") String keyword) {
        List<OffreDeStageDTO> searchResults = offreDeStageService.searchOffreDeStages(keyword);
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/validate/{id}")
    public ResponseEntity<OffreDeStageDTO> validateOffreDeStage(@PathVariable Long id) {
        OffreDeStageDTO validatedOffreDeStage = offreDeStageService.validateOffreDeStage(id);
        return ResponseEntity.ok(validatedOffreDeStage);
    }

    @GetMapping("/entreprise/{entreprise}")
    public ResponseEntity<List<OffreDeStageDTO>> getOffreStagesByEntreprise(@PathVariable String entreprise) {
        List<OffreDeStageDTO> offreDeStages = offreDeStageService.getOffreDeStagesByEntreprise(entreprise);
        return ResponseEntity.ok(offreDeStages);
    }

    @GetMapping("/non-valide")
    public List<OffreDeStageDTO> getNonValideOffreDeStages() {
        return offreDeStageService.getNonValidatedOffers();
    }

}