package com.demo.pagamento_picpay.models;

import java.math.BigDecimal;

import com.demo.pagamento_picpay.alertas.AlertaSaqueDeposito;
import com.demo.pagamento_picpay.alertas.AlertaTransferencia;
import com.demo.pagamento_picpay.entities.User;
import com.demo.pagamento_picpay.enums.TipoMensagem;
import com.demo.pagamento_picpay.utils.Mensagem;

public class ServiceCarteira{

    public static Mensagem transferir(User user, User userDestino, BigDecimal valor) {
        
        return new AlertaTransferencia("Transferencia realizada!", user, TipoMensagem.SUCESSO, valor, userDestino);
    }

    public static Mensagem depositar(User user, BigDecimal valor) {

        return new AlertaSaqueDeposito("Deposito", "Deposito realizado com sucesso!", user, TipoMensagem.SUCESSO, valor);
    }

    public static Mensagem sacar(User user, BigDecimal valor) {

        return new AlertaSaqueDeposito("Saque", "Saque realizado com sucesso!", user, TipoMensagem.SUCESSO, valor);    
    }
    
}
