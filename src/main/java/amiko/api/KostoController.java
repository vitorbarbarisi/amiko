package amiko.api;

import amiko.api.facade.KostoServiceFacade;
import amiko.api.to.KostoTO;
import amiko.api.to.KostojRequestTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class KostoController {

    @Autowired
    KostoServiceFacade kostoServiceFacade;
    
    @GetMapping("/kosto")
    public String getKosto() {
        return "GET KOSTO";
    }

    @GetMapping("/kostoj")
    public ResponseEntity<List<KostoTO>> getAllKostoj(KostojRequestTO request) {
        List<KostoTO> kostoTOList = kostoServiceFacade.getAllKostoj(request);
        return ResponseEntity.ok(kostoTOList);
    }

    @PostMapping("/kosto")
    public ResponseEntity<Long> addKosto(@RequestBody KostoTO request) {
        Long kostoId = kostoServiceFacade.createKosto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(kostoId);
    }

    @PutMapping("/kosto")
    public String updateKosto() {
        return "UPDATE KOSTO";
    }
    
}
