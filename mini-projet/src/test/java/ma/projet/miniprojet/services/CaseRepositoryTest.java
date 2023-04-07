package ma.projet.miniprojet.services;

import ma.projet.miniprojet.entities.Case;
import ma.projet.miniprojet.repositories.CaseRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CaseRepositoryTest {
    @Autowired
    private CaseRepository repo;

    @Test
    public void testCreateCase(){
        Case cas = new Case(null, new Date(), new Date(),"Case1","That is a case");
        Case savedCase = repo.save(cas);

        assertNotNull(savedCase);
        assertThat(savedCase.getCaseId()).isEqualTo(cas.getCaseId());
        assertThat(savedCase.getTitle()).isEqualTo(cas.getTitle());
        assertThat(savedCase.getCreationDate()).isEqualTo(cas.getCreationDate());
        assertThat(savedCase.getLastUpdateDate()).isEqualTo(cas.getLastUpdateDate());
        assertThat(savedCase.getDescription()).isEqualTo(cas.getDescription());

    }

    @Test
    public void testReadCase(){
        Case cas = repo.findById(1L).get();
        Assertions.assertThat(cas.getCaseId()).isEqualTo(1L);
    }

    @Test
    public void testUpdateCase() {
        Case cas = repo.findById(1L).get();
        cas.setTitle("Update");
        Case updatedCase = repo.save(cas);
        assertThat(updatedCase.getTitle()).isEqualTo(cas.getTitle());
    }
    @Test
    public void testDeleteCase(){
        Case cas = repo.findById(2L).get();
        repo.delete(cas);
        Case case1 = null;
        Optional<Case> optionalCase = repo.findById(2L);
        if(optionalCase.isPresent()){
            Assertions.assertThat(case1).isNull();
        }

        }




}