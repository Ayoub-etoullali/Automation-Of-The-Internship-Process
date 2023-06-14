package ma.enset.gestionStage.dtos;

import lombok.Data;
import ma.enset.gestionStage.entities.Admin;
import java.util.Date;

@Data
public class OffreStageDTO {
    private Long id;
    private String poste;
    private String entreprise;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String technologie;
    private Admin admin;
    private EtudiantDTO etudiantDTO;
}
