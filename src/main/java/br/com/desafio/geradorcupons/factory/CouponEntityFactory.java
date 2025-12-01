package br.com.desafio.geradorcupons.factory;

import br.com.desafio.geradorcupons.dto.request.CouponRequest;
import br.com.desafio.geradorcupons.entity.CouponEntity;
import br.com.desafio.geradorcupons.enums.StatusCouponEnum;

import java.time.LocalDateTime;

public class CouponEntityFactory {

    public static CouponEntity createFrom(CouponRequest couponRequest) {
        return new CouponEntity.Builder()
                .code(couponRequest.getCode())
                .description(couponRequest.getDescription())
                .discountValue(couponRequest.getDiscountValue())
                .expirationDate(couponRequest.getExpirationDate())
                .published(couponRequest.getPublished())
                .status(StatusCouponEnum.ACTIVE)
                .redeemed(false)
                .build();
    }

    public static CouponEntity createFrom(CouponEntity couponEntity) {
        return new CouponEntity.Builder()
                .id(couponEntity.getId())
                .code(couponEntity.getCode())
                .description(couponEntity.getDescription())
                .discountValue(couponEntity.getDiscountValue())
                .expirationDate(couponEntity.getExpirationDate())
                .published(couponEntity.isPublished())
                .status(StatusCouponEnum.DELETED)
                .createdAt(couponEntity.getCreatedAt())
                .deletedAt(LocalDateTime.now())
                .redeemed(couponEntity.isRedeemed())
                .build();
    }
}
