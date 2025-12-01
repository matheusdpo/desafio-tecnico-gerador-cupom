package br.com.desafio.geradorcupons.controller;


import br.com.desafio.geradorcupons.dto.CouponRequest;
import br.com.desafio.geradorcupons.dto.response.CouponResponse;
import br.com.desafio.geradorcupons.entity.CouponEntity;
import br.com.desafio.geradorcupons.factory.CouponEntityFactory;
import br.com.desafio.geradorcupons.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cupom/")
public class GeradorCuponsController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody(required = true) CouponRequest couponRequest) {
        try {
            CouponEntity couponEntity = CouponEntityFactory.createFrom(couponRequest);

            couponService.save(couponEntity);

            return ResponseEntity.ok(new CouponResponse("Your coupon has been created successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();

        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete() {
        return ResponseEntity.ok("ok");

    }
}
