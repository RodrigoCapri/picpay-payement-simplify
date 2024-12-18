package com.demo.pagamento_picpay.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.demo.pagamento_picpay.domains.Carteira;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    protected String id;
    protected String name;
    protected String email;

    @DBRef
    protected Carteira carteira;
    
}
