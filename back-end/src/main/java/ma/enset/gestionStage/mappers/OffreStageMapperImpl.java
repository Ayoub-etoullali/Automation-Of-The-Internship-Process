package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.OffreStageDTO;
import ma.enset.gestionStage.entities.OffreStage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class OffreStageMapperImpl implements OffreStageMapper {
    private EtudiantMapper mapper;

    @Override
    public OffreStageDTO fromOffreStage(OffreStage offreStage) {
        OffreStageDTO offreStageDTO = new OffreStageDTO();
        BeanUtils.copyProperties(offreStage, offreStageDTO);
        offreStageDTO.setEtudiantDTO(mapper.fromEtudiant(offreStage.getEtudiant()));
        return offreStageDTO;
    }

    @Override
    public OffreStage fromOffreStageDTO(OffreStageDTO offreStageDTO) {
        OffreStage offreStage = new OffreStage();
        BeanUtils.copyProperties(offreStageDTO, offreStage);
        offreStage.setEtudiant(mapper.fromEtudiantDTO(offreStageDTO.getEtudiantDTO()));
        return offreStage;
    }

}