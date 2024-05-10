package tn.esprit.devoir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devoir.entite.Acte;

public interface ActeRepo extends JpaRepository<Acte, Long> {
    Acte findByCodeActe(String codeActe);
}
