package com.demo.pagamento_picpay.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.pagamento_picpay.domains.UserLojista;

public interface UserLojistaRepository extends MongoRepository<UserLojista, String> {

}
