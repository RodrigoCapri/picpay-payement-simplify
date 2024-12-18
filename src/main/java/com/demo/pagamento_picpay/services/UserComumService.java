package com.demo.pagamento_picpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pagamento_picpay.domains.UserComum;
import com.demo.pagamento_picpay.repositories.UserComumRepository;
import com.demo.pagamento_picpay.services.exceptions.ObjectNotFoundException;

@Service

public class UserComumService {

    @Autowired
    private UserComumRepository userComumRepository;

    public List<UserComum> findAll() {
        return userComumRepository.findAll();
    }

    public UserComum findById(String id) {

        return userComumRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException(id) );

    }

    public UserComum insert(UserComum userComum) {
        return userComumRepository.insert(userComum);
    }

    public UserComum update(UserComum userComum) {

        UserComum userComumUpdate = findById(userComum.getId());

        userComumUpdate.setCpf(userComum.getCpf());
        userComumUpdate.setName(userComum.getName());
        userComumUpdate.setEmail(userComum.getEmail());
        userComumUpdate.setCarteira(userComum.getCarteira());

        return userComumRepository.save(userComum);
    }

    public void delete(String id) { 

        findById(id);

        userComumRepository.deleteById(id);
    }

}
