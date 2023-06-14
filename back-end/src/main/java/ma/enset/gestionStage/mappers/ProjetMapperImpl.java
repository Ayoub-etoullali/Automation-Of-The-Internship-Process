package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.ProjetDTO;
import ma.enset.gestionStage.entities.Projet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjetMapperImpl implements ProjetMapper {
    private StageMapper mapper;
    @Override
    public ProjetDTO fromProjet(Projet projet) {
        ProjetDTO projetDTO=new ProjetDTO();
        BeanUtils.copyProperties(projet, projetDTO);
        projetDTO.setStageDTO(mapper.fromStage(projet.getStage()));
        return projetDTO;
    }

    @Override
    public Projet fromProjetDTO(ProjetDTO projetDTO) {
        Projet projet=new Projet();
        BeanUtils.copyProperties(projetDTO, projet);
        projet.setStage(mapper.fromStageDTO(projetDTO.getStageDTO()));
        return projet;
    }

}
