package com.demo.pagamento_picpay.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

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

public class Movimento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private User user;

    private BigDecimal valor;

}
