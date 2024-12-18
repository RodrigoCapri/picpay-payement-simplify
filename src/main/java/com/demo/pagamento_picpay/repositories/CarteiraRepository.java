package com.demo.pagamento_picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pagamento_picpay.entities.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
