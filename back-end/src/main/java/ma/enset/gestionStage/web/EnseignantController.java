package ma.enset.gestionStage.web;

import ma.enset.gestionStage.dtos.EnseignantDTO;
import ma.enset.gestionStage.services.EnseignantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
@CrossOrigin(origins = "*")
public class EnseignantController {

    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public ResponseEntity<List<EnseignantDTO>> getAllEnseignants() {
        List<EnseignantDTO> enseignantDTOs = enseignantService.getAllEnseignants();
        return new ResponseEntity<>(enseignantDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignantDTO> getEnseignantById(@PathVariable Long id) {
        EnseignantDTO enseignantDTO = enseignantService.getEnseignantById(id);
        return new ResponseEntity<>(enseignantDTO, HttpStatus.OK);
    }

}