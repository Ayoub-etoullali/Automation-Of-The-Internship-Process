package ma.enset.gestionStage.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OffreDeStageDTO {
    private long id;
    private String poste;
    private String entreprise;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String technologie;
    private Boolean validated;
}