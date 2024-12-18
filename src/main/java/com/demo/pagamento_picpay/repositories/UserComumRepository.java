package com.demo.pagamento_picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pagamento_picpay.entities.UserComum;

public interface UserComumRepository extends JpaRepository<UserComum, Long> {

}
