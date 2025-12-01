package br.com.desafio.geradorcupons.factory;

import br.com.desafio.geradorcupons.dto.CouponRequest;
import br.com.desafio.geradorcupons.entity.CouponEntity;

public class CouponEntityFactory {

    public static CouponEntity createFrom(CouponRequest couponRequest) {
        return new CouponEntity.Builder()
                .code(couponRequest.getCode())
                .description(couponRequest.getDescription())
                .discountValue(couponRequest.getDiscountValue())
                .expirationDate(couponRequest.getExpirationDate())
                .published(couponRequest.getPublished())
                .couponDeleted(false)
                .build();
    }
}
