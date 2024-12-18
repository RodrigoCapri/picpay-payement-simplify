package com.demo.pagamento_picpay.entities;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)

public class Transferencia extends Movimento {

    @EqualsAndHashCode.Exclude
    private User userDestino;

}
