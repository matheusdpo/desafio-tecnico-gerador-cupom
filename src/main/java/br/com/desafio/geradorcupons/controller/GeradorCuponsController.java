package br.com.desafio.geradorcupons.controller;


import br.com.desafio.geradorcupons.dto.CouponRequest;
import br.com.desafio.geradorcupons.dto.response.CouponResponse;
import br.com.desafio.geradorcupons.dto.response.CouponResponseError;
import br.com.desafio.geradorcupons.entity.CouponEntity;
import br.com.desafio.geradorcupons.exception.CouponInvalidException;
import br.com.desafio.geradorcupons.factory.CouponEntityFactory;
import br.com.desafio.geradorcupons.service.CouponService;
import br.com.desafio.geradorcupons.utils.CouponUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/cupom/")
public class GeradorCuponsController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody(required = true) CouponRequest couponRequest) {
        try {
            final LocalDate today = LocalDate.now();
            final String promoCodeRefactor = CouponUtils.formatCouponCode(couponRequest.getCode());
            couponRequest.setCode(promoCodeRefactor);

            if (couponRequest.getExpirationDate().isBefore(today)) {
                throw new CouponInvalidException("Expiration value must be valid today or later");
            }

            double min_discount = 0.5;
            if (couponRequest.getDiscountValue() < min_discount) {
                throw new CouponInvalidException("Discount value must be larger than R$ 0.5");
            }

            CouponEntity couponEntity = CouponEntityFactory.createFrom(couponRequest);

            couponService.saveOrUpdate(couponEntity);

            return ResponseEntity.status(CREATED.value())
                    .body(new CouponResponse("Your coupon has been created successfully"));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(CONFLICT.value())
                    .body(new CouponResponseError("Code already registered"));
        } catch (Exception e) {
            return ResponseEntity.status(BAD_REQUEST.value())
                    .body(new CouponResponseError(e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> delete(@PathVariable(required = true) String code) {
        try {
            Optional<CouponEntity> couponEntityOptional = couponService.findByCodeAndCouponDeletedFalse(code);

            if (couponEntityOptional.isEmpty()) {
                throw new CouponInvalidException("Coupon does not exist or already deleted");
            }

            CouponEntity couponEntity = CouponEntityFactory.createFrom(couponEntityOptional.get());

            couponService.saveOrUpdate(couponEntity);

            return ResponseEntity.ok(new CouponResponse("Coupon deleted successfully"));
        } catch (CouponInvalidException c) {
            return ResponseEntity.status(CONFLICT.value())
                    .body(new CouponResponseError(c.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR.value())
                    .body(new CouponResponseError(e.getMessage()));
        }
    }
}
