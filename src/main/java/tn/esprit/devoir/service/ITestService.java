package tn.esprit.devoir.service;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import tn.esprit.devoir.entite.FamilleActe;
import tn.esprit.devoir.entite.Pathologie;
import tn.esprit.devoir.entite.Patient;

import java.util.Date;
import java.util.List;

public interface ITestService {
    Pathologie ajouterPathologie(Pathologie path);
    Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath);
    FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte);
    void affecterActeAPathologie(String codeActe , String codePathologie);
    float calculerFacture(String identifiant);
    void calculerNombreActesParPathologie();
    List<String> listIdentifiantsPatientsParCritere(String libelleActe, Float prix, Date dateE);
    }
