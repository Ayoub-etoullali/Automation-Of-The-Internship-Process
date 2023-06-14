package ma.enset.gestionStage.dtos;

import lombok.Data;
import ma.enset.gestionStage.entities.Filiere;
import ma.enset.gestionStage.entities.OffreStage;

@Data
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String email;
    private String CNE;
    private String CIN;
    private String telephone;
    private String adresse;
//    private StageDTO stage;
    private Filiere filiere;

}