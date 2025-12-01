package br.com.desafio.geradorcupons.controller;


import br.com.desafio.geradorcupons.dto.CouponRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cupom/")
public class GeradorCuponsController {

    @PostMapping("/create")
    public ResponseEntity<?> create() {
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        return ResponseEntity.ok("ok");

    }
}
