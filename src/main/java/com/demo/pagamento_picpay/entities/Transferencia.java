package com.demo.pagamento_picpay.entities;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)

@Entity(name = "tb_transferencia")
public class Transferencia extends Movimento {

    @EqualsAndHashCode.Exclude
    private User userDestino;

}
