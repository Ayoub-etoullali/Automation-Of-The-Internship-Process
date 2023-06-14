package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EnseignantDTO;
import ma.enset.gestionStage.entities.Enseignant;

import java.util.List;

public interface EnseignantMapper {
    public EnseignantDTO toDTO(Enseignant enseignant);
    public Enseignant toEntity(EnseignantDTO enseignantDTO);
    public List<EnseignantDTO> toDTOList(List<Enseignant> enseignants);

}