package com.demo.pagamento_picpay.domains;

import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.pagamento_picpay.entities.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "doc_user_comum")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

public class UserComum extends User{

    @EqualsAndHashCode.Exclude
    private String cpf;

}
