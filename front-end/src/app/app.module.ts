import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FullCalendarModule } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxChartsModule } from '@swimlane/ngx-charts';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EtudiantComponent } from './components/etudiant/etudiant.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProjetsComponent } from './components/projets/projets.component';
import { OffresStageComponent } from './components/offres-stage/offres-stage.component';
import { LoginComponent } from './login/login.component';
import { DetailsOffreStageComponent } from './components/offres-stage/details/details-offre-stage.component';
import { NewProjetComponent } from './components/projets/add/new-projet.component';
import { EditProjetComponent } from './components/projets/edit/edit-projet.component';
import { EditEtudiantComponent } from './components/etudiant/edit/edit-etudiant.component';
import { StagesComponent } from './components/stages/stages.component';
import { EncadrantEtudiantComponent } from './components/encadrant-etudiant/encadrant-etudiant.component';
import { SessionComponent } from './components/session/session.component';
import { UpdateSessionComponent } from './components/update-session/update-session.component';
import { AddSessionComponent } from './components/add-session/add-session.component';
import { CalendarComponent } from './components/calendar/calendar.component';
import { LivrableComponent } from './components/livrable/livrable.component';
import {StageComponent} from "./components/stage/stage.component";
import {CreatestageComponent} from "./components/stage/createstage/createstage.component";
import { OffreDeStageComponent } from './components/offre-de-stage/offre-de-stage/offre-de-stage.component';
import { AddOffreDeStageComponent } from './components/offre-de-stage/add-offre/add-offre.component';
import { UpdateOffreDeStageComponent } from './components/offre-de-stage/update-offre/update-offre.component';
import { DetailsOffreComponent } from './components/offre-de-stage/details-offre/details-offre.component';
import { ValidateOffreComponent } from './components/offre-de-stage/validate-offre/validate-offre.component';
import { ChartComponent } from './components/stage/chart/chart.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component'
import {ForumComponent} from "./components/forum/forum.component";
import {DetailsPostesComponent} from "./components/forum/details/details-postes.component";

@NgModule({
  declarations: [
    AppComponent,
    EtudiantComponent,
    AcceuilComponent,
    NavbarComponent,
    ProjetsComponent,
    OffresStageComponent,
    LoginComponent,
    DetailsOffreStageComponent,
    NewProjetComponent,
    EditProjetComponent,
    EditEtudiantComponent,
    StagesComponent,
    EncadrantEtudiantComponent,
    SessionComponent,
    UpdateSessionComponent,
    AddSessionComponent,
    CalendarComponent,
    LivrableComponent,
    StageComponent,
    CreatestageComponent,
    OffreDeStageComponent,
    AddOffreDeStageComponent,
    UpdateOffreDeStageComponent,
    DetailsOffreComponent,
    ValidateOffreComponent,
    ChartComponent,
    ForumComponent,
    DetailsPostesComponent,
    DashboardComponent,
    ProfileComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FullCalendarModule,
    NgxChartsModule,
    BrowserAnimationsModule
  ],
  providers: [
    { provide: 'plugins', useFactory: () => [dayGridPlugin] }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
