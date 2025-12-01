package br.com.desafio.geradorcupons.service;

import br.com.desafio.geradorcupons.entity.CouponEntity;
import br.com.desafio.geradorcupons.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public CouponEntity saveOrUpdate(CouponEntity couponEntity) {
        return couponRepository.save(couponEntity);
    }

    public Optional<CouponEntity> findByCodeAndCouponDeletedFalse(String code) {
        return couponRepository.findByCodeAndCouponDeletedFalse(code);
    }
}