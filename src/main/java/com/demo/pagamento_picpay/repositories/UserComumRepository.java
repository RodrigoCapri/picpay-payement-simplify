package com.demo.pagamento_picpay.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.pagamento_picpay.domains.UserComum;

public interface UserComumRepository extends MongoRepository<UserComum, String> {

}
