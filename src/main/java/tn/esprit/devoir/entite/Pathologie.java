package tn.esprit.devoir.entite;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Pathologie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPath;
    private String codePath;
    private String libelle;
    private String description;
    private Boolean archive;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Acte> acte;

}
