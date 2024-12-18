package com.demo.pagamento_picpay.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demo.pagamento_picpay.entities.Carteira;
import com.demo.pagamento_picpay.entities.UserComum;
import com.demo.pagamento_picpay.entities.UserLojista;
import com.demo.pagamento_picpay.repositories.UserComumRepository;
import com.demo.pagamento_picpay.repositories.UserLojistaRepository;

@Configuration

public class Inicio implements CommandLineRunner {

    @Autowired
    private UserComumRepository userComumRepository;

    @Autowired
    private UserLojistaRepository userLojistaRepository;

    @Override
    public void run(String... args) throws Exception {
        
        UserComum userComum1 = new UserComum(null, "Ricardo da Silva", "ricardo@gmail.com", null, "00033344455");
        UserComum userComum2 = new UserComum(null, "Maria de Oliveira", "maria@gmail.com", null, "11177788822");
        userComumRepository.saveAll(Arrays.asList(userComum1, userComum2));

        UserLojista userLojista1 = new UserLojista(null, "00011122233345", "Serigo Ramos", "sergio@gmail.com", null);    
        UserLojista userLojista2 = new UserLojista(null, "77799944433388", "Larissa Pereira", "larissa@gmail.com", null);
        userLojistaRepository.saveAll(Arrays.asList(userLojista1, userLojista2));

        Carteira carteira1 = new Carteira(null, BigDecimal.valueOf(1000.00), userComum1);
        Carteira carteira2 = new Carteira(null, BigDecimal.valueOf(500.00), userComum2);
        Carteira carteira3 = new Carteira(null, BigDecimal.valueOf(50000.00), userLojista1);
        Carteira carteira4 = new Carteira(null, BigDecimal.valueOf(120000.00), userLojista2);
        userComum1.setCarteira(carteira1);
        userComum2.setCarteira(carteira2);
        userLojista1.setCarteira(carteira3);
        userLojista2.setCarteira(carteira4);

        userComumRepository.saveAll(Arrays.asList(userComum1, userComum2));
        userLojistaRepository.saveAll(Arrays.asList(userLojista1, userLojista2));

    }

}
