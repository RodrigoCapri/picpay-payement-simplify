package com.demo.pagamento_picpay.dtos;

import com.demo.pagamento_picpay.entities.UserLojista;

public class UserLojistaDTO extends UserDTO {

    private String cnpj;

    public UserLojistaDTO() {
    }

    public UserLojistaDTO(UserLojista user) {
        super(user);
        this.cnpj = user.getCnpj();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
