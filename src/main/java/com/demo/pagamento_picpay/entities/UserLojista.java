package com.demo.pagamento_picpay.entities;

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

@Entity(name = "tb_user_lojista")
public class UserLojista extends User{
    
    @EqualsAndHashCode.Exclude
    private String cnpj;

}
