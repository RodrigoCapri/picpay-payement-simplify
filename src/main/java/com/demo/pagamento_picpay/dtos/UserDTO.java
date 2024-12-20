package com.demo.pagamento_picpay.dtos;

import java.io.Serializable;

import com.demo.pagamento_picpay.entities.User;

public class UserDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;
    private String email;
    private Long carteira;

    public UserDTO(){
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.nome = user.getName();
        this.email = user.getEmail();
        this.carteira = (user.getCarteira() != null) ? user.getCarteira().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCarteira() {
        return carteira;
    }

    public void setCarteira(Long carteira) {
        this.carteira = carteira;
    }

}
