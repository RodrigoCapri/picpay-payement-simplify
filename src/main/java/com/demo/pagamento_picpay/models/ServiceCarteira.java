package com.demo.pagamento_picpay.models;

import com.demo.pagamento_picpay.domains.Carteira;
import com.demo.pagamento_picpay.entities.User;

public class ServiceCarteira{

    static Carteira getCarteira(User user) {
        return user.getCarteira();
    }

}
