package ma.projet.miniprojet.repositories;

import ma.projet.miniprojet.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {


}
