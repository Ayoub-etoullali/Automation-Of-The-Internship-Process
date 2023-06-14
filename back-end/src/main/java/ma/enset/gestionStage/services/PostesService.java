package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.PostesDTO;

import java.util.List;

public interface PostesService {
    PostesDTO savePostes(PostesDTO postesDTO);

    List<PostesDTO> getAllPostes();

    PostesDTO UpdatePostes(Long id, PostesDTO postesDTO);

    void deletePostes(Long id);

    List<PostesDTO> ChercherPostesByTag(String tag);

    List<PostesDTO> ChercherPostesByTitre(String titre);
}
