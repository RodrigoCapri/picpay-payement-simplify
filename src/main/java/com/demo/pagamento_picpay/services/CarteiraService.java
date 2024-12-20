package com.demo.pagamento_picpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pagamento_picpay.entities.Carteira;
import com.demo.pagamento_picpay.repositories.CarteiraRepository;
import com.demo.pagamento_picpay.services.exceptions.ObjectNotFoundException;

@Service

public class CarteiraService {

    @Autowired
    private CarteiraRepository carteiraRepository;

    public List<Carteira> findAll() {

        return carteiraRepository.findAll();

    }

    public Carteira findById(Long id) {

        return carteiraRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado: "+id) );

    }

    public Carteira insert(Carteira carteira) {

        return carteiraRepository.save(carteira);

    }

    public Carteira update(Carteira carteira) {

        Carteira carteiraUpdate = findById(carteira.getId());

        carteiraUpdate.setSaldo(carteira.getSaldo());
        carteiraUpdate.setUser(carteira.getUser());

        return carteiraRepository.save(carteira);
    }

    public void delete(Long id) { 

        findById(id);

        carteiraRepository.deleteById(id);
        
    }

}
