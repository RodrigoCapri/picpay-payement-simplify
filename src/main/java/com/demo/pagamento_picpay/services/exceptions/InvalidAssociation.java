package com.demo.pagamento_picpay.services.exceptions;

public class InvalidAssociation extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAssociation(String message) {
        super(message);
    }

}
