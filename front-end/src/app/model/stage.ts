import {Etudiant} from "./Etudiant.model";

export interface Stage {
  id: number;
  titre: string;
  description: string;
  date_debut: Date;
  date_fin: Date;
  utite_d_accueil: string;
  etudiant: Etudiant
}
