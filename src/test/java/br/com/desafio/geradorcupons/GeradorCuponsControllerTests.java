package br.com.desafio.geradorcupons;

import br.com.desafio.geradorcupons.controller.GeradorCuponsController;
import br.com.desafio.geradorcupons.dto.request.CouponRequest;
import br.com.desafio.geradorcupons.dto.response.CouponResponse;
import br.com.desafio.geradorcupons.entity.CouponEntity;
import br.com.desafio.geradorcupons.enums.StatusCouponEnum;
import br.com.desafio.geradorcupons.exception.CouponInvalidException;
import br.com.desafio.geradorcupons.service.CouponService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest
class GeradorCuponsControllerTests {

    @InjectMocks
    private GeradorCuponsController cuponsController;

    @Mock
    private CouponService couponService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_success() {
        CouponRequest request = new CouponRequest();
        request.setCode("AB@1"); //codigo com caracter especial e menos de 6, devera ser preenchido
        request.setDescription("Promoção Teste");
        request.setDiscountValue(1.0); //valor ok
        request.setPublished(true);
        request.setExpirationDate(LocalDate.now().plusDays(1));

        ResponseEntity<CouponResponse> response = cuponsController.create(request);

        assertEquals(CREATED, response.getStatusCode());
        assertEquals("Your coupon has been created successfully", response.getBody().getMessage());
        verify(couponService, times(1)).saveOrUpdate(any());
    }

    @Test
    void create_discountValue_lower() {
        CouponRequest request = new CouponRequest();
        request.setCode("ABC123");
        request.setDescription("Promoção Teste");
        request.setDiscountValue(0.1); //valor menor que 0.5
        request.setExpirationDate(LocalDate.now().plusDays(1));

        assertThrows(CouponInvalidException.class, () -> cuponsController.create(request));
    }

    @Test
    void create_expirationDate_yesterday() {
        CouponRequest request = new CouponRequest();
        request.setCode("ABC123");
        request.setDescription("Promoção Teste");
        request.setDiscountValue(1.0);
        request.setExpirationDate(LocalDate.now().minusDays(1)); //ontem

        assertThrows(CouponInvalidException.class, () -> cuponsController.create(request));
    }

    @Test
    void create_no_fields() {
        CouponRequest request = new CouponRequest();

        assertThrows(NullPointerException.class, () -> cuponsController.create(request));
    }



}
