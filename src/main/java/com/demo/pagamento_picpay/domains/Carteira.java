package com.demo.pagamento_picpay.domains;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.pagamento_picpay.entities.Movimento;
import com.demo.pagamento_picpay.entities.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Document(collection = "doc_carteira")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Carteira{

    @Id
    private String id;

    private BigDecimal saldo;

    private User user;

    @DBRef(lazy = true)
    private Set<Movimento> movimentos = new HashSet<>();

    public Carteira(String id, BigDecimal saldo, User user) {
        this.id = id;
        this.saldo = saldo;
        this.user = user;
    }

}
