package tn.esprit.devoir.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FamilleActe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFA;
    private String codeFA;
    private String libelle;
    private String description;
    @OneToMany(mappedBy = "familleActe")
    private List<Acte> acte;

}
