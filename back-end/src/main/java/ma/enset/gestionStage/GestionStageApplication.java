package ma.enset.gestionStage;

import ma.enset.gestionStage.dtos.*;
import ma.enset.gestionStage.entities.*;
import ma.enset.gestionStage.mappers.EncadrantPedagogiqueMapper;
import ma.enset.gestionStage.mappers.EtudiantMapper;
import ma.enset.gestionStage.mappers.OffreDeStageMapper;
import ma.enset.gestionStage.mappers.OffreStageMapper;
import ma.enset.gestionStage.repositories.AdminRepository;
import ma.enset.gestionStage.security.entities.AppRole;
import ma.enset.gestionStage.security.entities.AppUser;
import ma.enset.gestionStage.security.services.AccountService;
import ma.enset.gestionStage.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Stream;


@SpringBootApplication
public class GestionStageApplication {
    public GestionStageApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionStageApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EtudiantService etudiantService,
                                        OffreStageService offreStageService,
                                        ProjetService projetService,
                                        StageService stageService,
                                        OffreDeStageService offreDeStageService,
                                        AdminService adminService,
                                        OffreDeStageMapper offreDeStageMapper,
                                        AccountService accountService,
                                        EnseignantService enseignantService,
                                        EncadrantPedagogiqueService encadrantPedagogiqueService,
                                        PostesService postesService) {
        return (args) -> {
            final int[] i = {1};
            Stream.of("jimin", "jungkook", "namjoon").forEach(login -> {
                AdminDTO adminDTO = new AdminDTO();
                adminDTO.setId(i[0]);
                adminDTO.setLogin(login);
                adminDTO.setPassword(login + UUID.randomUUID());
                adminService.saveAdmin(adminDTO);
                i[0]++;
            });
            List<OffreStageDTO> offreStageDTOS = new ArrayList<>();
                Stream.of("Data Science", "Data Analyst", "Data Engineer", "Mobile Developer",
                        "Backend Developer", "Frontend Developer").forEach(post -> {
                    OffreDeStageDTO offreDeStageDTO = new OffreDeStageDTO();
                    offreDeStageDTO.setEntreprise("Informatique");
                    offreDeStageDTO.setDateDebut(new Date());
                    offreDeStageDTO.setDateFin(new Date());
                    offreDeStageDTO.setTechnologie("Java");
                    offreDeStageDTO.setDescription("");
                    offreDeStageDTO.setPoste(post);
                    OffreDeStage offreDeStage = offreDeStageService.saveOffreDeStage(offreDeStageMapper.DTOToOffreDeStage(offreDeStageDTO));
                    offreDeStageDTO.setId(offreDeStage.getId());
                });
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "CHEF_FIL"));
            accountService.addNewRole(new AppRole(null, "ENCADRANT"));
            accountService.addNewRole(new AppRole(null, "ETUDIANT"));
            accountService.addNewUser(new AppUser(null, "admin", "admin", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Jimin", "1310", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Jungkook", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Namjoon", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Jin", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Yoongi", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Hoseok", "7777", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Taehyung", "7777", new ArrayList<>()));
            accountService.addRoleToUser("admin", "ADMIN");
            accountService.addRoleToUser("Jimin", "CHEF_FIL");
            accountService.addRoleToUser("Jungkook", "CHEF_FIL");
            accountService.addRoleToUser("Namjoon", "ETUDIANT");
            accountService.addRoleToUser("Jin", "ENCADRANT");
            accountService.addRoleToUser("Yoongi", "ENCADRANT");
            accountService.addRoleToUser("Hoseok", "CHEF_FIL");
            accountService.addRoleToUser("Taehyung", "ETUDIANT");
            Stream.of("Jimin", "Jungkook", "Hoseok").forEach(name -> {
                EnseignantDTO enseignantDTO = new EnseignantDTO();
                enseignantDTO.setNom(name);
                enseignantDTO.setEmail(name + "@gmail.com");
                enseignantDTO.setResponsableFiliere(true);
                enseignantService.saveEnseignant(enseignantDTO);
            });
            Stream.of("Jin", "Yoongi").forEach(name -> {
                EncadrantPedagogiqueDTO encadrantPedagogiqueDTO = new EncadrantPedagogiqueDTO();
                encadrantPedagogiqueDTO.setNom(name);
                encadrantPedagogiqueDTO.setEmail(name + "@gmail.com");
                encadrantPedagogiqueService.saveEncadrantPedagogique(encadrantPedagogiqueDTO);
            });
            Stream.of("Namjoon", "Taehyung").forEach(name -> {
                EtudiantDTO etudiantDTO = new EtudiantDTO();
                etudiantDTO.setNom(name);
                etudiantDTO.setEmail(name + "@gmail.com");
                etudiantService.createEtudiant(etudiantDTO);
            });
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setLogin("admin");
            adminDTO.setPassword("admin");
            adminService.saveAdmin(adminDTO);

            //=> Etudiant
            Stream.of("ayoub", "hayat", "samira", "mustapha", "karima", "radouan").forEach(name -> {
                EtudiantDTO etudiantDTO = new EtudiantDTO();
                etudiantDTO.setPrenom(name);
                etudiantDTO.setNom("ETOULLALI");
                etudiantDTO.setEmail(name + "@gmail.com");
                etudiantDTO.setUsername(name);
                etudiantDTO.setPassword(name);
                etudiantDTO.setCNE("M" + new String());
                etudiantDTO.setCIN("U" + new String());
                etudiantDTO.setTelephone("+212 6" + new String());
                etudiantDTO.setAdresse("ERRACHIDIA");
                etudiantService.createEtudiant(etudiantDTO);
            });

            etudiantService.getAllEtudiants().forEach(etudiant -> {

                //=> Stage
                StageDTO stageDTO = new StageDTO();
                stageDTO.setTitre("stage de " + etudiant.getPrenom());
                stageDTO.setDescription("");
                stageDTO.setEtudiantDTO(etudiant);
                StageDTO stage_=stageService.saveStage(stageDTO);

                //=> Projet
                Collection<ProjetDTO> projetDTOS=new ArrayList<>();
                Stream.of("projet 1","projet 2","projet 3").forEach(intitule->{
                    ProjetDTO projetDTO=new ProjetDTO();
                    projetDTO.setStageDTO(stage_);
                    projetDTO.setIntitule(intitule);
                    projetDTO.setPath("https://"+new String());
                    projetDTO.setDescription("Description about "+intitule);
                    projetService.saveProjet(projetDTO);
                    projetDTOS.add(projetDTO);
                });

                //=> Filière

                //=> Offre de stage
                List<OffreStageDTO> offreStageDTOSs = new ArrayList<>();
                Stream.of("Data Science", "Data Analyst", "Data Engineer", "Mobile Developer",
                        "Backend Developer", "Frontend Developer").forEach(post -> {
                    OffreStageDTO offreStageDTO = new OffreStageDTO();
                    offreStageDTO.setEntreprise("Informatique");
                    offreStageDTO.setDateDebut(new Date());
                    offreStageDTO.setDateFin(new Date());
                    offreStageDTO.setTechnologie("Java");
                    offreStageDTO.setDescription("");
                    offreStageDTO.setPoste(post);
                    offreStageDTO.setEtudiantDTO(etudiant);
                    offreStageService.saveOffreStage(offreStageDTO);
                    offreStageDTOSs.add(offreStageDTO);
                });

            });

            Stream.of("java", "spring", "data-scientist", "web-developer", "ai", "ml").forEach(name -> {
                PostesDTO poste = new PostesDTO();
                poste.setTitre("Poste "+name);
                poste.setDescription("Description de poste "+name);
                poste.setTag(name);
                poste.setDate(new Date());
                poste.setAutheur("Autheur");
                postesService.savePostes(poste);
            });

            //=> Problem
            //System.out.println(projetService.getProjetById(1L));

            System.out.println("\n </> By Ayoub ETOULLALI \n");

        };



    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
