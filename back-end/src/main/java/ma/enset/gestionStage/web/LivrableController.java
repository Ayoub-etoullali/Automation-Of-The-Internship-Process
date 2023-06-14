package ma.enset.gestionStage.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.gestionStage.entities.Livrable;
import ma.enset.gestionStage.services.LivrableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encadrant")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class LivrableController {

    private LivrableService livrableService;

    @GetMapping("/stage/{stageId}/livrables")
    public ResponseEntity<List<Livrable>> getLivrablesByStageId(@PathVariable Long stageId) {
        List<Livrable> livrables = livrableService.getLivrablesByStageId(stageId);
        return new ResponseEntity<>(livrables, HttpStatus.OK);
    }

}
