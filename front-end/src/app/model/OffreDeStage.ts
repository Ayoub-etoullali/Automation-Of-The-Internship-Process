export interface OffreDeStage {
  id: number;
  poste: string;
  entreprise: string;
  description: string;
  dateDebut: Date;
  dateFin: Date;
  technologie: string;
  validated: boolean;
}

export interface OffreDeStageDetails {
  id: number;
  poste: string;
  entreprise: string;
  description: string;
  dateDebut: Date;
  dateFin: Date;
  technologie: string;
  adminLogin: string;
  adminPassword: string;
  validated: boolean;
}
