package com.demo.pagamento_picpay.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demo.pagamento_picpay.entities.UserComum;
import com.demo.pagamento_picpay.repositories.UserComumRepository;

@Configuration

public class Inicio implements CommandLineRunner {

    @Autowired
    private UserComumRepository userComumRepository;

    @Override
    public void run(String... args) throws Exception {
        
        /*UserComum userComum1 = new UserComum(null, "Ricardo da Silva", "ricardo@gmail.com", null, "00033344455");
        UserComum userComum2 = new UserComum(null, "Maria de Oliveira", "maria@gmail.com", null, "11177788822");

        userComumRepository.saveAll(Arrays.asList(userComum1, userComum2));*/

    }

}
