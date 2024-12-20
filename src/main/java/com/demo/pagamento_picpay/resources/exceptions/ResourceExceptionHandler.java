package com.demo.pagamento_picpay.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.pagamento_picpay.services.exceptions.InvalidAssociation;
import com.demo.pagamento_picpay.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String error = "Recurso não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND; //Não encontrado 404
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

    @ExceptionHandler(InvalidAssociation.class)
    public ResponseEntity<StandardError> invalidAssociation(InvalidAssociation e, HttpServletRequest request){
        String error = "Associação inválida!";
        HttpStatus status = HttpStatus.BAD_REQUEST; //BadRequest 400
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request){
        String error = "Argumento inválido!";
        HttpStatus status = HttpStatus.BAD_REQUEST; //BadRequest 400
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }

    @ExceptionHandler(DeleteAssociationException.class)
    public ResponseEntity<StandardError> deleteAssociation(DeleteAssociationException e, HttpServletRequest request){
        String error = "Erro de associação!";
        HttpStatus status = HttpStatus.CONFLICT; //Conflict 409
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }

}
