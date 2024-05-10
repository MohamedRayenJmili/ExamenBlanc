package tn.esprit.devoir.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.devoir.entite.FamilleActe;
import tn.esprit.devoir.entite.Pathologie;
import tn.esprit.devoir.entite.Patient;
import tn.esprit.devoir.repository.ActeRepo;
import tn.esprit.devoir.repository.FARepo;
import tn.esprit.devoir.repository.PathRepo;
import tn.esprit.devoir.repository.PatientRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Float.sum;

@Slf4j
@Service
@AllArgsConstructor
public class TestServiceImp implements ITestService{
    ActeRepo acteRepo;
    FARepo faRepo;
    PathRepo pathRepo;
    PatientRepo patientRepo;
    @Override
    public Pathologie ajouterPathologie(Pathologie path) {
        if (path.getActe() == null)
            path.setActe(new ArrayList<>());
        if(path.getArchive() == null)
            path.setArchive(false);
        return pathRepo.save(path);
    }

    @Override
    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath) {
        Pathologie path = pathRepo.findByCodePath(codePath);
        if (p.getPathologie() == null)
            p.setPathologie(new ArrayList<>());
        p.getPathologie().add(path);

        return patientRepo.save(p);
    }

    @Override
    public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte) {
        FamilleActe familleActe = faRepo.save(facte);
        facte.getActe().forEach(acte -> {
            acte.setFamilleActe(familleActe);
            acteRepo.save(acte);
        });
        return familleActe;
    }

    @Override
    public void affecterActeAPathologie(String codeActe, String codePathologie) {
        Pathologie path = pathRepo.findByCodePath(codePathologie);
        path.getActe().add(acteRepo.findByCodeActe(codeActe));
        pathRepo.save(path);
    }
    @Override
    public float calculerFacture(String identifiant) {
        float s = 0;
        if (pathRepo.findByCodePath(identifiant) != null) {
            return pathRepo.findByCodePath(identifiant).getActe().stream().map(acte -> acte.getCotationActe() * acte.getPrixUnitaireActe()).reduce(0f, Float::sum);
        }
        else {
            return pathRepo.findByLibelle(identifiant).getActe().stream().map(acte -> acte.getCotationActe() * acte.getPrixUnitaireActe()).reduce(0f, Float::sum);
        }
    }
    @Scheduled(fixedDelay = 30000)
    @Override
    public void calculerNombreActesParPathologie() {
        pathRepo.findAll().forEach(path -> {
            log.info("Pathologie: " + path.getLibelle() + " Nombre d'actes: " + path.getActe().size());
        });
    }

    @Override
    public List<String> listIdentifiantsPatientsParCritere(String libelleActe, Float prix, Date dateE) {
        //return patientRepo.findAll().stream().filter(patient -> patient.getPathologie().stream()
          //              .anyMatch(pathologie -> pathologie.getActe().stream()
            //            .anyMatch(acte -> acte.getDesignationActe().equals(libelleActe) && acte.getPrixUnitaireActe() >= prix)))
              //          .filter(patient -> patient.getDateEmission().equals(dateE))
                //        .map(Patient::getIdentifiantPieceIdentity).collect(Collectors.toList());
       return patientRepo.findAllByPathologieActeDesignationActeAndPathologieActePrixUnitaireActeGreaterThanEqual(libelleActe, prix).stream()
                   .filter(patient -> patient.getDateEmission().equals(dateE))
                   .map(Patient::getIdentifiantPieceIdentity).collect(Collectors.toList());
    }

    //@Scheduled(cron = "*/30 * * * * *")
    //log.info("Every 30 seconds: ");
}
