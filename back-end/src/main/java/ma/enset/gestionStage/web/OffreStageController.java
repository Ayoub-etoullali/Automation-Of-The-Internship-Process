package ma.enset.gestionStage.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.OffreStageDTO;
import ma.enset.gestionStage.dtos.OffreStageHistoryDTO;
import ma.enset.gestionStage.services.OffreStageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/offres-stage")
@CrossOrigin("*")
public class OffreStageController {
    private OffreStageService offreStageService;

    @GetMapping("/all")
    public List<OffreStageDTO> getAllOffreStage(){
        return offreStageService.findAllOffreStage();
    }

    @GetMapping("/{id}")
    public OffreStageDTO getOffreStage(@PathVariable Long id){
        return offreStageService.findOffreStageById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOffreStage(@PathVariable Long id){
        offreStageService.deleteOffreStageById(id);
    }

    @PutMapping("/edit/{id}")
    public OffreStageDTO editOffreStage(@PathVariable Long id, @RequestBody OffreStageDTO  offreStage){
        offreStage.setId(id);
        return offreStageService.UpdateOffreStage(id,offreStage);
    }

    @PostMapping("/new-offre-stage")
    public OffreStageDTO newEtudiant(@RequestBody OffreStageDTO offreStage){
        return offreStageService.saveOffreStage(offreStage);
    }

    @GetMapping("/entreprise/{entreprise}")
    public List<OffreStageDTO> searchOffreStageByEntreprise(@PathVariable String entreprise){
        return offreStageService.ChercherOffreStageByEntreprise(entreprise);
    }

    @GetMapping("/poste/search")
    public List<OffreStageDTO> searchOffreStageByPoste(@RequestParam(defaultValue = "") String poste){
        return offreStageService.ChercherOffreStageByPoste(poste);
    }

    @GetMapping("/technologie/{technologie}")
    public List<OffreStageDTO> searchOffreStageByTechnologie(@PathVariable String technologie){
        return offreStageService.ChercherOffreStageByTechnologie(technologie);
    }

    /**Page**/
    @GetMapping("/{id}/pageOperations")
    public OffreStageHistoryDTO getOffreStageHistory(@PathVariable Long id,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(name = "size",defaultValue = "5") int size)  {
        return offreStageService.getOffreStageHistory(id,page,size);
    }
}
