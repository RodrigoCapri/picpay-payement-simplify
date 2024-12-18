package com.demo.pagamento_picpay.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "tb_carteira")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Carteira{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private BigDecimal saldo;
    private User user;
    private Set<Movimento> movimentos = new HashSet<>();

    public Carteira(Long id, BigDecimal saldo, User user) {
        this.id = id;
        this.saldo = saldo;
        this.user = user;
    }

}
