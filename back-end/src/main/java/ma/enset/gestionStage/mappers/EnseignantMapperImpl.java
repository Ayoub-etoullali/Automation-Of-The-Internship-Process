package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EnseignantDTO;
import ma.enset.gestionStage.entities.Enseignant;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EnseignantMapperImpl implements EnseignantMapper {
    @Override
    public EnseignantDTO toDTO(Enseignant enseignant) {
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        enseignantDTO.setId(enseignant.getId());
        enseignantDTO.setNom(enseignant.getNom());
        enseignantDTO.setPrenom(enseignant.getPrenom());
        enseignantDTO.setEmail(enseignant.getEmail());
        enseignantDTO.setCNE(enseignant.getCNE());
        enseignantDTO.setCodeApogee(enseignant.getCodeApogee());
        enseignantDTO.setUsername(enseignant.getUsername());
        enseignantDTO.setPassword(enseignant.getPassword());
        enseignantDTO.setResponsableFiliere(enseignant.isResponsableFiliere());
        enseignantDTO.setResponsableDepartement(enseignant.isResponsableDepartement());
        return enseignantDTO;
    }

    @Override
    public Enseignant toEntity(EnseignantDTO enseignantDTO) {
        Enseignant enseignant = new Enseignant();
        enseignant.setId(enseignantDTO.getId());
        enseignant.setNom(enseignantDTO.getNom());
        enseignant.setPrenom(enseignantDTO.getPrenom());
        enseignant.setEmail(enseignantDTO.getEmail());
        enseignant.setCNE(enseignantDTO.getCNE());
        enseignant.setCodeApogee(enseignantDTO.getCodeApogee());
        enseignant.setUsername(enseignantDTO.getUsername());
        enseignant.setPassword(enseignantDTO.getPassword());
        enseignant.setResponsableFiliere(enseignantDTO.isResponsableFiliere());
        enseignant.setResponsableDepartement(enseignantDTO.isResponsableDepartement());
        return enseignant;
    }

    @Override
    public List<EnseignantDTO> toDTOList(List<Enseignant> enseignants) {
        return enseignants.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}