package com.demo.pagamento_picpay.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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

@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_user") 
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    @SequenceGenerator(name = "userSequence", sequenceName = "user_seq", allocationSize = 1)
    protected Long id;
    protected String name;
    protected String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carteira_id")
    protected Carteira carteira;

    @OneToMany(mappedBy = "user")
    private Set<Movimento> movimentos = new HashSet<>();

    public User(Long id, String name, String email, Carteira carteira) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.carteira = carteira;
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
