package ma.projet.miniprojet;

import ma.projet.miniprojet.entities.Case;
import ma.projet.miniprojet.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MiniProjetApplication implements CommandLineRunner {
    @Autowired
    private CaseService service;

    public static void main(String[] args) {

        SpringApplication.run(MiniProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Case cas1 = new Case(null, new Date(), new Date(),"Case1","That is a case");
        Case cas2 = new Case(null, new Date(), new Date(),"Case2","That is another case");
        service.CreateCase(cas1);
        service.CreateCase(cas2);
        System.out.println(service.ReadCase(1L).toString());
        Case cas3 = new Case(null, new Date(), new Date(),"Case2","That is an updated case");
        Case cas4 = new Case(null, new Date(), new Date(),"Case3","This is a third case");
        service.CreateCase(cas4);
        service.UpdateCase(2L,cas3);
        service.DeleteCase(1L);

    }
}
