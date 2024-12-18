package com.demo.pagamento_picpay.domains;

import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.pagamento_picpay.entities.User;

import lombok.EqualsAndHashCode;

@Document(collection = "doc_user_comum")

@EqualsAndHashCode(callSuper = true)

public class UserComum extends User{

    @EqualsAndHashCode.Exclude
    private String cpf;

}
