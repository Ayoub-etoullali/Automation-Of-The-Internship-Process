package ma.enset.gestionStage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "etudiants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToOne(mappedBy = "etudiant")
    private Stage stage;
    @ManyToOne
    private Filiere filiere;
    @OneToMany(mappedBy = "etudiant",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OffreStage> offreStages;
}