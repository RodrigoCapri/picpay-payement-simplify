package com.demo.pagamento_picpay.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

@Entity
@DiscriminatorValue("UserComum")
public class UserComum extends User{

    @EqualsAndHashCode.Exclude
    private String cpf;

    public UserComum(Long id, String name, String email, Carteira carteira, String cpf) {

        super(id, name, email, carteira);

        this.cpf = cpf;
        
    }

}
