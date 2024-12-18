package com.demo.pagamento_picpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pagamento_picpay.entities.UserLojista;
import com.demo.pagamento_picpay.repositories.UserLojistaRepository;
import com.demo.pagamento_picpay.services.exceptions.ObjectNotFoundException;

@Service

public class UserLojistaService {

    @Autowired
    private UserLojistaRepository userLojistaRepository;

    public List<UserLojista> findAll() {
        return userLojistaRepository.findAll();
    }

    public UserLojista findById(Long id) {

        return userLojistaRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado: "+id) );

    }

    public UserLojista insert(UserLojista userLojista) {
        return userLojistaRepository.save(userLojista);
    }

    public UserLojista update(UserLojista userLojista) {

        UserLojista userLojistaUpdate = findById(userLojista.getId());

        userLojistaUpdate.setCnpj(userLojista.getCnpj());
        userLojistaUpdate.setName(userLojista.getName());
        userLojistaUpdate.setEmail(userLojista.getEmail());
        userLojistaUpdate.setCarteira(userLojista.getCarteira());

        return userLojistaRepository.save(userLojista);
    }

    public void delete(Long id) { 

        findById(id);

        userLojistaRepository.deleteById(id);
    }

}
