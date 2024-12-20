package com.demo.pagamento_picpay.models;

import java.math.BigDecimal;

import com.demo.pagamento_picpay.alertas.AlertaSaqueDeposito;
import com.demo.pagamento_picpay.alertas.AlertaTransferencia;
import com.demo.pagamento_picpay.entities.User;
import com.demo.pagamento_picpay.enums.TipoMensagem;
import com.demo.pagamento_picpay.models.exceptions.ServiceCarteiraException;
import com.demo.pagamento_picpay.utils.Mensagem;

public class ServiceCarteira{

    public static Mensagem transferir(User user, User userDestino, BigDecimal valor) {

        if(user.getCarteira() == null || userDestino.getCarteira() == null) {
            throw new ServiceCarteiraException("Carteira nao encontrada!");
        }

        if(user.equals(userDestino)) {
            throw new ServiceCarteiraException("Usuario nao pode se transferir para ele mesmo!");
        }

        if(user.getCarteira().getSaldo().compareTo(valor) < 0) {
            return new AlertaTransferencia("Transferencia nao realizada!\nSaldo insuficiente", user, TipoMensagem.ERRO, valor, userDestino);
        }

        user.getCarteira().setSaldo(user.getCarteira().getSaldo().subtract(valor));
        userDestino.getCarteira().setSaldo(userDestino.getCarteira().getSaldo().add(valor));

        return new AlertaTransferencia("Transferencia realizada com sucesso!", user, TipoMensagem.SUCESSO, valor, userDestino);
    }

    public static Mensagem depositar(User user, BigDecimal valor) {

        if(user.getCarteira() == null) {
            throw new ServiceCarteiraException("Carteira nao encontrada!");
        }

        user.getCarteira().setSaldo(user.getCarteira().getSaldo().add(valor));

        return new AlertaSaqueDeposito("Deposito", "Deposito realizado com sucesso!", user, TipoMensagem.SUCESSO, valor);

    }

    public static Mensagem sacar(User user, BigDecimal valor) {

        if(user.getCarteira() == null) {
            throw new ServiceCarteiraException("Carteira nao encontrada!");
        }

        if(user.getCarteira().getSaldo().compareTo(valor) < 0) {
            return new AlertaSaqueDeposito("Saque","Saque nao realizado!\nSaldo insuficiente", user, TipoMensagem.ERRO, valor);
        }

        user.getCarteira().setSaldo(user.getCarteira().getSaldo().subtract(valor));

        return new AlertaSaqueDeposito("Saque", "Saque realizado com sucesso!", user, TipoMensagem.SUCESSO, valor);
          
    }
    
}
