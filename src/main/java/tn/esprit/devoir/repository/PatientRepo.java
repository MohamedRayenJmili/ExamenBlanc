package tn.esprit.devoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devoir.entite.Patient;

import java.util.Date;
import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findAllByPathologieActeDesignationActeAndPathologieActePrixUnitaireActeGreaterThanEqual(String libelleActe, float prix);
}
