package com.demo.pagamento_picpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pagamento_picpay.domains.UserLojista;
import com.demo.pagamento_picpay.repositories.UserLojistaRepository;
import com.demo.pagamento_picpay.services.exceptions.ObjectNotFoundException;

@Service

public class UserLojistaService {

    @Autowired
    private UserLojistaRepository userLojistaRepository;

    public List<UserLojista> findAll() {
        return userLojistaRepository.findAll();
    }

    public UserLojista findById(String id) {

        return userLojistaRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException(id) );

    }

    public UserLojista insert(UserLojista userLojista) {
        return userLojistaRepository.insert(userLojista);
    }

    public UserLojista update(UserLojista userLojista) {

        UserLojista userLojistaUpdate = findById(userLojista.getId());

        userLojistaUpdate.setCnpj(userLojista.getCnpj());
        userLojistaUpdate.setName(userLojista.getName());
        userLojistaUpdate.setEmail(userLojista.getEmail());
        userLojistaUpdate.setCarteira(userLojista.getCarteira());

        return userLojistaRepository.save(userLojista);
    }

    public void delete(String id) { 

        findById(id);

        userLojistaRepository.deleteById(id);
    }

}
