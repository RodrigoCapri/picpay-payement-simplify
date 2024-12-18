package com.demo.pagamento_picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pagamento_picpay.entities.UserLojista;

public interface UserLojistaRepository extends JpaRepository<UserLojista, Long> {

}
