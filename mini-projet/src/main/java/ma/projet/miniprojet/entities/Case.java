package ma.projet.miniprojet.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/*La generation des getters, setters,
des differents constructeurs et
la methode toString() est faite avec Lombok*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Case {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long caseId;
    private Date creationDate;
    private Date lastUpdateDate;
    @Column(length = 255)
    private String title;
    @Column(length = 2056)
    private String description;
}
