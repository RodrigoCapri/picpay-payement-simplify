package com.demo.pagamento_picpay.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString

@Entity
@DiscriminatorValue("UserLojista")
public class UserLojista extends User{
    
    @EqualsAndHashCode.Exclude
    private String cnpj;

    public UserLojista(Long id, String cnpj, String name, String email, Carteira carteira) {
        
        super(id, name, email, carteira);

        this.cnpj = cnpj;
    }

    public UserLojista(Long id, String name, String email, String cnpj) {
        super(id, name, email);
        this.cnpj = cnpj;
    }

}
