package com.demo.pagamento_picpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pagamento_picpay.dtos.UserComumDTO;
import com.demo.pagamento_picpay.entities.Carteira;
import com.demo.pagamento_picpay.entities.UserComum;
import com.demo.pagamento_picpay.repositories.CarteiraRepository;
import com.demo.pagamento_picpay.repositories.UserComumRepository;
import com.demo.pagamento_picpay.services.exceptions.ObjectNotFoundException;

@Service

public class UserComumService {

    @Autowired
    private UserComumRepository userComumRepository;

    @Autowired
    private CarteiraRepository carteiraRepository;

    public List<UserComum> findAll() {
        return userComumRepository.findAll();
    }

    public UserComum findById(Long id) {

        return userComumRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado: "+id) );

    }

    public UserComum insert(UserComum userComum) {
        return userComumRepository.save(userComum);
    }

    public UserComum update(UserComum userComum) {

        UserComum userComumUpdate = findById(userComum.getId());

        userComumUpdate.setCpf(userComum.getCpf());
        userComumUpdate.setName(userComum.getName());
        userComumUpdate.setEmail(userComum.getEmail());
        userComumUpdate.setCarteira(userComum.getCarteira());

        return userComumRepository.save(userComum);
    }

    public void delete(Long id) { 

        findById(id);

        userComumRepository.deleteById(id);
    }

    public UserComum fromDTO(UserComumDTO userComumDTO) {

        UserComum userComum = new UserComum(userComumDTO.getId(), userComumDTO.getNome(), userComumDTO.getEmail(), userComumDTO.getCpf());

        if(userComumDTO.getCarteira() != null) {

            Carteira carteira = carteiraRepository.findById(userComumDTO.getCarteira()).orElseThrow( () -> new ObjectNotFoundException("Objeto nao encontrado: "+userComumDTO.getCarteira()) );

            userComum.setCarteira(carteira);

        }

        return userComum;
    }

}
