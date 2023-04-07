package ma.projet.miniprojet.services;

import ma.projet.miniprojet.entities.Case;

import java.util.List;

public interface CaseService {
    Case CreateCase(Case cas) ;
    Case ReadCase(Long id);
    Case UpdateCase(Long id, Case cas);
    String DeleteCase(Long id);


}
