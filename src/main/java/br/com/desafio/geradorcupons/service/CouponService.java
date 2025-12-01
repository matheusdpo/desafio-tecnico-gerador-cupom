package br.com.desafio.geradorcupons.service;

import br.com.desafio.geradorcupons.entity.CouponEntity;
import br.com.desafio.geradorcupons.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public CouponEntity save(CouponEntity couponEntity) {
        return couponRepository.save(couponEntity);
    }

}