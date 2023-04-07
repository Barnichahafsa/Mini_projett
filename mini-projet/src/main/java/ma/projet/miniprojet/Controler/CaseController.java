package ma.projet.miniprojet.Controler;

import lombok.AllArgsConstructor;
import ma.projet.miniprojet.entities.Case;
import ma.projet.miniprojet.services.CaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
@AllArgsConstructor
public class CaseController {
    private final CaseService caseService;
    @PostMapping("/")
    public Case create(@RequestBody Case cas){
        return caseService.CreateCase(cas);
    }
    @GetMapping("/{id}")
    public Case read(@PathVariable Long id){
        Case cas = caseService.ReadCase(id);
        if(cas == null){
            throw new RuntimeException("Case unfound !");
        }
        return cas;
    }
    @PutMapping("/{id}")
    public Case update(@PathVariable Long id,@RequestBody Case cas){
        return caseService.UpdateCase(id,cas);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return caseService.DeleteCase(id);
    }

}
