package com.demo.pagamento_picpay.dtos;

import com.demo.pagamento_picpay.entities.UserComum;

public class UserComumDTO extends UserDTO{

    private String cpf;

    public UserComumDTO() {
    }

    public UserComumDTO(UserComum user) {
        super(user);
        this.cpf = user.getCpf();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
