package ma.enset.gestionStage.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.gestionStage.dtos.PostesDTO;
import ma.enset.gestionStage.entities.Postes;
import ma.enset.gestionStage.mappers.PostesMapper;
import ma.enset.gestionStage.repositories.PostesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Slf4j
public class PostesServiceImpl implements PostesService {
    private PostesRepository postesRepository;
    private PostesMapper mapper;
    @Override
    public PostesDTO savePostes(PostesDTO postesDTO) {
        Postes postes=mapper.fromPostesDTO(postesDTO);
        return mapper.fromPostes(postesRepository.save(postes));
    }

    @Override
    public List<PostesDTO> getAllPostes() {
        List<Postes> postes = postesRepository.findAll();
        List<PostesDTO> postesDTOS = postes
                .stream()
                .map(poste -> mapper.fromPostes(poste))
                .collect(Collectors.toList()); //String to list
        return postesDTOS;
    }

    @Override
    public PostesDTO UpdatePostes(Long id, PostesDTO postesDTO) {
        return mapper.fromPostes(postesRepository.findById(id).orElse(null));
    }

    @Override
    public void deletePostes(Long id) {
        postesRepository.deleteById(id);
    }

    @Override
    public List<PostesDTO> ChercherPostesByTag(String tag) {
        List<Postes> postes = postesRepository.searchPostesByTag(tag);
        List<PostesDTO> postesDTOS = postes
                .stream()
                .map(poste -> mapper.fromPostes(poste))
                .collect(Collectors.toList()); //String to list
        return postesDTOS;
    }

    @Override
    public List<PostesDTO> ChercherPostesByTitre(String titre) {
        List<Postes> postes = postesRepository.searchPostesByTitre(titre);
        List<PostesDTO> postesDTOS = postes
                .stream()
                .map(poste -> mapper.fromPostes(poste))
                .collect(Collectors.toList()); //String to list
        return postesDTOS;
    }
}
