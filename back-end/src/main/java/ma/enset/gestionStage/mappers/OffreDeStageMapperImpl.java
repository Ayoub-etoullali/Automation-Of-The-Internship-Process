package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.OffreDeStageDTO;
import ma.enset.gestionStage.dtos.OffreDeStageDetailsDTO;
import ma.enset.gestionStage.entities.OffreDeStage;
import ma.enset.gestionStage.entities.Admin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OffreDeStageMapperImpl implements OffreDeStageMapper, OffreDeStageDetailsMapper{
    @Override
    public OffreDeStageDTO offreDeStageToDTO(OffreDeStage offreDeStage) {
        OffreDeStageDTO dto = new OffreDeStageDTO();
        dto.setId(offreDeStage.getId());
        dto.setPoste(offreDeStage.getPoste());
        dto.setEntreprise(offreDeStage.getEntreprise());
        dto.setDescription(offreDeStage.getDescription());
        dto.setDateDebut(offreDeStage.getDateDebut());
        dto.setDateFin(offreDeStage.getDateFin());
        dto.setTechnologie(offreDeStage.getTechnologie());
        dto.setValidated(offreDeStage.getValidated());
        return dto;
    }

    @Override
    public OffreDeStage DTOToOffreDeStage(OffreDeStageDTO dto) {
        OffreDeStage offreDeStage = new OffreDeStage();
        offreDeStage.setId(dto.getId());
        offreDeStage.setPoste(dto.getPoste());
        offreDeStage.setEntreprise(dto.getEntreprise());
        offreDeStage.setDescription(dto.getDescription());
        offreDeStage.setDateDebut(dto.getDateDebut());
        offreDeStage.setDateFin(dto.getDateFin());
        offreDeStage.setTechnologie(dto.getTechnologie());

        Admin admin = new Admin();

        return offreDeStage;
    }

    @Override
    public OffreDeStageDetailsDTO offreDeStageToDetailsDTO(OffreDeStage offreDeStage) {
        OffreDeStageDetailsDTO dto = new OffreDeStageDetailsDTO();
        dto.setId(offreDeStage.getId());
        dto.setPoste(offreDeStage.getPoste());
        dto.setEntreprise(offreDeStage.getEntreprise());
        dto.setDescription(offreDeStage.getDescription());
        dto.setDateDebut(offreDeStage.getDateDebut());
        dto.setDateFin(offreDeStage.getDateFin());
        dto.setTechnologie(offreDeStage.getTechnologie());
        return dto;
    }

    public List<OffreDeStageDTO> offreDeStageListToDTOList(List<OffreDeStage> offreDeStages) {
        return offreDeStages.stream()
                .map(this::offreDeStageToDTO)
                .collect(Collectors.toList());
    }

}