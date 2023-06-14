import {Etudiant} from "./Etudiant.model";

/**Page**/
export interface OffreStageDetails {
  id: number;
  currentPage: number;
  totalPage: number;
  sizePage: number;
  offreStageDTOS: OffreStage[];
}

export interface OffreStage {
  id: number;
  poste: string;
  entreprise: string;
  description: string;
  dateDebut: string;
  dateFin: string;
  technologie: string;
  postuler: boolean;
  admin: any;
  etudiantDTO: Etudiant;
}


