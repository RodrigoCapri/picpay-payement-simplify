package com.demo.pagamento_picpay.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@DiscriminatorValue("Transferencia")
public class Transferencia extends Movimento {

    @EqualsAndHashCode.Exclude
    private User userDestino;

    public Transferencia(Long id, User user, Carteira carteira, LocalDate data, BigDecimal valor, User userDestino) {

        super(id, user, carteira, data, valor);
        
        this.userDestino = userDestino;
    }
    
}
