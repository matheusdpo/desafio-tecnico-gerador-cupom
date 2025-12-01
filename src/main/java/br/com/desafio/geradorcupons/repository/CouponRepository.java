package br.com.desafio.geradorcupons.repository;

import br.com.desafio.geradorcupons.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
