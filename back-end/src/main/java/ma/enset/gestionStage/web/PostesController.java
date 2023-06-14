package ma.enset.gestionStage.web;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.PostesDTO;
import ma.enset.gestionStage.services.PostesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/postes")
@CrossOrigin("*")
public class PostesController {
    private PostesService postesService;

    @GetMapping("/all")
    public List<PostesDTO> getAllProjet(){
        return postesService.getAllPostes();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePoste(@PathVariable Long id){
        postesService.deletePostes(id);
    }

    @PutMapping("/edit/{id}")
    public PostesDTO editPoqte(@PathVariable Long id, @RequestBody PostesDTO  postesDTO){
        postesDTO.setId(id);
        return postesService.UpdatePostes(id,postesDTO);
    }

    @PostMapping("/new-Postes")
    public PostesDTO newPoste(@RequestBody PostesDTO postesDTO){
        return postesService.savePostes(postesDTO);
    }

    @GetMapping("/tags/{tags}")
    public List<PostesDTO> searchPosteBytags(@PathVariable String tags){
        return postesService.ChercherPostesByTag(tags);
    }

    @GetMapping("/tags/search")
    public List<PostesDTO> searchPostesBytags(@RequestParam(defaultValue = "") String tags){
        return postesService.ChercherPostesByTag(tags);
    }

    @GetMapping("/titres/search")
    public List<PostesDTO> searchPostesByTitres(@RequestParam(defaultValue = "") String titre){
        return postesService.ChercherPostesByTitre(titre);
    }

}
