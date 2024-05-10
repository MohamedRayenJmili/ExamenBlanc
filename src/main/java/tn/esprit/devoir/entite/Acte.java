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
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActe;
    private String codeActe;
    private int cotationActe;
    private float prixUnitaireActe;
    private String designationActe;
    @ManyToOne
    private FamilleActe familleActe;
    @ManyToMany(mappedBy = "acte")
    private List<Pathologie> pathologie;

}
