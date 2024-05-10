package tn.esprit.devoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devoir.entite.FamilleActe;

public interface FARepo extends JpaRepository<FamilleActe, Long> {
}
