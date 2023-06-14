package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.PostesDTO;
import ma.enset.gestionStage.entities.Postes;

public interface PostesMapper {
    PostesDTO fromPostes(Postes postes);
    Postes fromPostesDTO(PostesDTO postesDTO);
}
