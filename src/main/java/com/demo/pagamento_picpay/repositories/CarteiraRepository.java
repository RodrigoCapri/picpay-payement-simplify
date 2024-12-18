package com.demo.pagamento_picpay.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.pagamento_picpay.domains.Carteira;

public interface CarteiraRepository extends MongoRepository<Carteira, String> {

}
