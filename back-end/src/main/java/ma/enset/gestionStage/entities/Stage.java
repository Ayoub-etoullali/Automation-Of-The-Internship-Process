package ma.enset.gestionStage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String utite_d_accueil;
    @Temporal(TemporalType.DATE)
    private Date date_debut;
    @Temporal(TemporalType.DATE)
    private Date date_fin;
    @OneToMany(mappedBy = "stage",fetch = FetchType.LAZY)
    private Collection<Livrable> livrables;
    @OneToMany(mappedBy = "stage")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projet> projets;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Etudiant etudiant;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToOne
    private Annee_universitaire annee_univ;
    @OneToOne(mappedBy = "stage",fetch = FetchType.LAZY)
    public Soutenance soutenance;
}
