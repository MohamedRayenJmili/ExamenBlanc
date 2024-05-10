package tn.esprit.devoir.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devoir.entite.FamilleActe;
import tn.esprit.devoir.entite.Pathologie;
import tn.esprit.devoir.entite.Patient;
import tn.esprit.devoir.service.ITestService;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/Examen-Blanc")
public class MyController {
    @Autowired
    ITestService testService;

        @PostMapping("/ajouterPathologie")
    public Pathologie ajouterPathologie(@RequestBody Pathologie c) {
            Pathologie path = testService.ajouterPathologie(c);
            return path;
        }
        @PostMapping("/ajouterPatientEtAffecterAPathologie/{codePath}")
    public Patient ajouterPatientEtAffecterAPathologie(@RequestBody Patient c, @PathVariable String codePath) {
            Patient patient = testService.ajouterPatientEtAffecterAPathologie(c , codePath);
            return patient;
        }

    @PostMapping("/ajouterFamilleActeEtActeAssocie")
    public FamilleActe ajouterFamilleActeEtActeAssocie(@RequestBody FamilleActe c) {
        FamilleActe familleActe = testService.ajouterFamilleActeEtActeAssocie(c);
        return familleActe;
    }
    @GetMapping("/affecterActeAPathologie/{codeActe}/{codePathologie}")
    public void affecterActeAPathologie(@PathVariable String codeActe, @PathVariable String codePathologie) {
        testService.affecterActeAPathologie(codeActe,codePathologie);
    }
    @GetMapping("/calculerFacture/{c}")
    public float calculerFacture(@PathVariable String c) {
        return testService.calculerFacture(c);
    }
    @GetMapping("/calculerNombreActesParPathologie/{libelleActe}/{prix}/{dateE}")
    List<String> listIdentifiantsPatientsParCritere(@PathVariable String libelleActe,@PathVariable Float prix,@PathVariable Date dateE){
        return testService.listIdentifiantsPatientsParCritere(libelleActe,prix,dateE);
    }
//    @PostMapping("/add-evenement")
//    public Evenement addChaeazembre(@RequestBody Evenement c) {
//        Evenement chambre = evenementService.ajoutAffectEvenParticip(c);
//        return chambre;


//    @GetMapping("/retrieve-logistique/{dd}/{df}")
//    public List<Logistique> getChambres(@PathVariable("dd")@DateTimeFormat(pattern = "yyyy-MM-dd") Date dd, @PathVariable("df")@DateTimeFormat(pattern = "yyyy-MM-dd") Date df) {
//        return logistiqueService.getLogistiquesDates(dd,df);
//

//    @GetMapping("/retrieve-par")
//    public List<Participant> getChambres() {
//        return participantService.getParReservLogis();
//    }




}
