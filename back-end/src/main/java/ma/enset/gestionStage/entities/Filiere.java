package ma.enset.gestionStage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nom;
    @OneToMany(mappedBy = "filiere",fetch =FetchType.LAZY )
    private Collection<Enseignant> enseignants ;
    @OneToMany(mappedBy = "filiere",fetch =FetchType.LAZY )
    private Collection<Etudiant> etudiants ;
    @ManyToOne
    private Departement departement;
}
