package tn.esprit.devoir.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
private String nomP;
private String prenomP;
    @Enumerated(EnumType.STRING)
private TypePieceIdentity typePieceIdentity;
private String identifiantPieceIdentity;
    @Temporal(TemporalType.DATE)
private Date dateEmission;
    @ManyToMany
    private List<Pathologie> pathologie;


}
