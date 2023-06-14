import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcceuilComponent } from "./components/acceuil/acceuil.component";
import { EtudiantComponent } from "./components/etudiant/etudiant.component";
import { OffresStageComponent } from "./components/offres-stage/offres-stage.component";
import { ProjetsComponent } from "./components/projets/projets.component";
import { LoginComponent } from "./login/login.component";
import { NavbarComponent } from "./navbar/navbar.component";
import { DetailsOffreStageComponent } from "./components/offres-stage/details/details-offre-stage.component";
import { EditProjetComponent } from "./components/projets/edit/edit-projet.component";
import { NewProjetComponent } from "./components/projets/add/new-projet.component";
import { EditEtudiantComponent } from "./components/etudiant/edit/edit-etudiant.component";
import { StagesComponent } from "./components/stages/stages.component";
import { EncadrantEtudiantComponent } from "./components/encadrant-etudiant/encadrant-etudiant.component";
import { SessionComponent } from "./components/session/session.component";
import { UpdateSessionComponent } from "./components/update-session/update-session.component";
import { AddSessionComponent } from "./components/add-session/add-session.component";
import { CalendarComponent } from "./components/calendar/calendar.component";
import {StageComponent} from "./components/stage/stage.component";
import {CreatestageComponent} from "./components/stage/createstage/createstage.component";
import { OffreDeStageComponent } from "./components/offre-de-stage/offre-de-stage/offre-de-stage.component"
import { AddOffreDeStageComponent } from './components/offre-de-stage/add-offre/add-offre.component';
import { UpdateOffreDeStageComponent } from './components/offre-de-stage/update-offre/update-offre.component';
import {ValidateOffreComponent} from "./components/offre-de-stage/validate-offre/validate-offre.component";
import { DetailsOffreComponent } from "./components/offre-de-stage/details-offre/details-offre.component"
import { ChartComponent } from './components/stage/chart/chart.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { ProfileComponent } from './components/profile/profile.component'
import {ForumComponent} from "./components/forum/forum.component";
import {DetailsPostesComponent} from "./components/forum/details/details-postes.component";

const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "login", component: LoginComponent },
  { path: "acceuil", component: AcceuilComponent },
  { path: "edit-projet/:id", component: EditProjetComponent },
  { path: "edit-etudiant/:id", component: EditEtudiantComponent },
  { path: "new-projet", component: NewProjetComponent },
  { path: "forum", component: ForumComponent },
  { path: "details-offre-stage/:id", component: DetailsOffreStageComponent },
  { path: "etudiant", component: EtudiantComponent },
  { path: "detail-postes/:id", component: DetailsPostesComponent },
  { path: "offres-stage", component: OffresStageComponent },
  { path: "projets", component: ProjetsComponent },
  { path: "stages", component: StagesComponent },
  { path: "encadrant-etudiant", component: EncadrantEtudiantComponent },
  { path: "encadrant-etudiant/:id", component: EncadrantEtudiantComponent },
  { path: "session", component: SessionComponent },
  { path: "calendar", component: CalendarComponent },
  { path: "stage", component: StageComponent },
  { path: "offre-de-stage", component: OffreDeStageComponent },
  { path: "validate-offre", component: ValidateOffreComponent},
  { path: "chart", component: ChartComponent},
  { path: "update-session/:id", component: UpdateSessionComponent },
  { path: "add-session", component: AddSessionComponent },
  { path: "createstage", component: CreatestageComponent },
  { path: "add-offre", component: AddOffreDeStageComponent },
  { path: "update-offre/:id", component: UpdateOffreDeStageComponent },
  { path: "details/:id", component: DetailsOffreComponent },
  { path: "dashboard", component: DashboardComponent },
  { path: 'session/:id', component: SessionComponent },
  { path: "profile", component: ProfileComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
