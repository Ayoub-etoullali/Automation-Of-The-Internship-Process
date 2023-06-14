package ma.enset.gestionStage.dtos;

import lombok.Data;
import ma.enset.gestionStage.entities.Annee_universitaire;
import ma.enset.gestionStage.entities.Entreprise;
import ma.enset.gestionStage.entities.Soutenance;

import java.util.Date;

@Data
public class StageDTO {
    private Long id;
    private String titre;
    private String description;
    private String utite_d_accueil;
    private Date date_debut;
    private Date date_fin;
    private EtudiantDTO etudiantDTO;
    private Entreprise entreprise;
    private Annee_universitaire annee_univ;
    public Soutenance soutenance;
}
