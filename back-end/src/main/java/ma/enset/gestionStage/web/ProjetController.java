package ma.enset.gestionStage.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.ProjetDTO;
import ma.enset.gestionStage.entities.OffreStage;
import ma.enset.gestionStage.entities.Projet;
import ma.enset.gestionStage.services.OffreStageService;
import ma.enset.gestionStage.services.ProjetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/projets")
@CrossOrigin("*")
public class ProjetController {
    private ProjetService projetService;

    @GetMapping("/all")
    public List<ProjetDTO> getAllProjet(){
        return projetService.getAllProjets();
    }

    @GetMapping("/{id}")
    public ProjetDTO getProjet(@PathVariable(name = "id") Long id){
        return projetService.getProjetById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjet(@PathVariable Long id){
        projetService.deleteProjet(id);
    }

    @PutMapping("/edit/{id}")
    public ProjetDTO editProjet(@PathVariable Long id, @RequestBody ProjetDTO  projetDTO){
        projetDTO.setId(id);
        return projetService.UpdateProjet(id,projetDTO);
    }

    @PostMapping("/new-projet")
    public ProjetDTO newProjet(@RequestBody ProjetDTO projet){
        return projetService.saveProjet(projet);
    }

    @GetMapping("/intitule/{intitule}")
    public List<ProjetDTO> searchProjetByIntitule(@PathVariable String intitule){
        return projetService.ChercherProjetByIntitule(intitule);
    }

    @GetMapping("/intitule/search")
    public List<ProjetDTO> searchProjetsByIntitule(@RequestParam(defaultValue = "") String intitule){
        return projetService.ChercherProjetByIntitule(intitule);
    }

}
