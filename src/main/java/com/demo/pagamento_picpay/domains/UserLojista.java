package com.demo.pagamento_picpay.domains;

import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.pagamento_picpay.entities.User;

import lombok.EqualsAndHashCode;

@Document(collection = "doc_user_lojista")

@EqualsAndHashCode(callSuper = true)

public class UserLojista extends User{
    
    @EqualsAndHashCode.Exclude
    private String cnpj;

}
