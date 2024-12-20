package com.demo.pagamento_picpay.models.exceptions;

public class ServiceCarteiraException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceCarteiraException(String message) {        
        super(message);
    }

}
