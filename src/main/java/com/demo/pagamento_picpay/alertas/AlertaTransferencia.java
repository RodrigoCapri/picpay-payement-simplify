package com.demo.pagamento_picpay.alertas;

import java.math.BigDecimal;

import com.demo.pagamento_picpay.entities.User;
import com.demo.pagamento_picpay.enums.TipoMensagem;
import com.demo.pagamento_picpay.utils.Mensagem;

public class AlertaTransferencia extends Mensagem{

    private BigDecimal  valor;
    private User userDestino;

    public AlertaTransferencia(String mensagem, User user, TipoMensagem tipoMensagem, BigDecimal valor, User userDestino) {
        
        super("Transferencia", mensagem, user, tipoMensagem);

        this.userDestino = userDestino;
        this.valor = valor;
    }

    @Override
    public void show() {

        System.out.println(tipoMensagem);
        System.out.println(titulo);
        System.out.println(mensagem);
        System.out.println(user.getName());
        System.out.println("Valor: " + valor);
        System.out.println("Destino: " + userDestino.getName());

    }

}
