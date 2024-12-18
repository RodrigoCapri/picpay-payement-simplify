package com.demo.pagamento_picpay.alertas;

import java.math.BigDecimal;

import com.demo.pagamento_picpay.entities.User;
import com.demo.pagamento_picpay.enums.TipoMensagem;
import com.demo.pagamento_picpay.utils.Mensagem;

public class AlertaSaqueDeposito extends Mensagem{

    private BigDecimal valor;

    public AlertaSaqueDeposito(String titulo, String mensagem, User user, TipoMensagem tipoMensagem, BigDecimal valor) {

        super(titulo, mensagem, user, tipoMensagem);

        this.valor = valor;

    }
    
    @Override
    public void show() {    
        System.out.println(tipoMensagem);
        System.out.println(titulo);
        System.out.println(mensagem);
        System.out.println(user.getName());
        System.out.println("Valor: " + valor);
    }

}
