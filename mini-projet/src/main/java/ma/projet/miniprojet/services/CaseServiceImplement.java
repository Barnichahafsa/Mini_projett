package ma.projet.miniprojet.services;

import lombok.AllArgsConstructor;
import ma.projet.miniprojet.entities.Case;
import ma.projet.miniprojet.repositories.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CaseServiceImplement implements CaseService{
    private final CaseRepository caseRepository;
    @Override
    public Case CreateCase(Case cas) {
        return caseRepository.save(cas);
    }

    @Override
    public Case ReadCase(Long id) {
        Optional<Case> resultat = caseRepository.findById(id);
        Case cas = null;
        if(resultat.isPresent()){
            cas=resultat.get();
        }else{
            throw new RuntimeException("Case unfound !");
        }
        return cas;
    }

    @Override
    public Case UpdateCase(Long id, Case cas) {
        return caseRepository.findById(id)
                .map(c ->{
                    c.setCreationDate(cas.getCreationDate());
                    c.setLastUpdateDate(cas.getLastUpdateDate());
                    c.setTitle(cas.getTitle());
                    c.setDescription(cas.getDescription());
                    return caseRepository.save(c);
                }).orElseThrow(()-> new RuntimeException("Case unfound !"));
    }

    @Override
    public String DeleteCase(Long id) {
        caseRepository.deleteById(id);
        return "Case deleted !";
    }
}
