package com.demo.pagamento_picpay.utils;

import com.demo.pagamento_picpay.entities.User;
import com.demo.pagamento_picpay.enums.TipoMensagem;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Mensagem {

    protected String titulo;
    protected String mensagem;
    protected User user;
    protected TipoMensagem tipoMensagem;

    public void show() { 
        System.out.println(tipoMensagem);
        System.out.println(titulo);
        System.out.println(mensagem);
        System.out.println(user.getName());
    }

}
