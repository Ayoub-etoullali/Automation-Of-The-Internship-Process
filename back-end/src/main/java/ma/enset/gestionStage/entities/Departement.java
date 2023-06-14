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
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany(mappedBy = "departement",fetch =FetchType.LAZY )
    private Collection<Enseignant> enseignants ;
    @OneToMany(mappedBy = "departement",fetch =FetchType.LAZY )
    private Collection<Filiere> filieres ;
}
