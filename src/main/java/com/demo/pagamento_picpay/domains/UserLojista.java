package com.demo.pagamento_picpay.domains;

import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.pagamento_picpay.entities.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "doc_user_lojista")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

public class UserLojista extends User{
    
    @EqualsAndHashCode.Exclude
    private String cnpj;

}
