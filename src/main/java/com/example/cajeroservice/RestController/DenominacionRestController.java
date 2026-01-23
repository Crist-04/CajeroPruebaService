package com.example.cajeroservice.RestController;

import com.example.cajeroservice.JPA.DenominacionJPA;
import com.example.cajeroservice.Service.DenominacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/denominacion")
@CrossOrigin(origins = "*")
public class DenominacionRestController {

    @Autowired
    private DenominacionService denominacionService;

    @GetMapping("/all")
    public ResponseEntity<List<DenominacionJPA>> getAll() {
        return ResponseEntity.ok(denominacionService.getAll());
    }
}
