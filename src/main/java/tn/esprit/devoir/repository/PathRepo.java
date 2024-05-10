package tn.esprit.devoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devoir.entite.Pathologie;

public interface PathRepo extends JpaRepository<Pathologie, Long> {
    Pathologie findByCodePath(String codePath);
    Pathologie findByLibelle(String identifiant);
}
