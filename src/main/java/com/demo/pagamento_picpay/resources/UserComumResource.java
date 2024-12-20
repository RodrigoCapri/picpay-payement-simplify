package com.demo.pagamento_picpay.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.pagamento_picpay.dtos.UserComumDTO;
import com.demo.pagamento_picpay.entities.UserComum;
import com.demo.pagamento_picpay.resources.exceptions.DeleteAssociationException;
import com.demo.pagamento_picpay.services.UserComumService;


@RestController
@RequestMapping(value = "/user/comum")
public class UserComumResource {

    @Autowired
    private UserComumService userComumService;

    @GetMapping
    public ResponseEntity< List<UserComumDTO> > findAll() {
        
        List<UserComum> list = userComumService.findAll();

        List<UserComumDTO> listDTO = list.stream().map(obj -> new UserComumDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity< UserComum > findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(userComumService.findById(id));

    }
    
    @PostMapping
    public ResponseEntity< UserComum > insert(@RequestBody UserComumDTO userComumDTO) {

        UserComum obj = userComumService.insert(userComumService.fromDTO(userComumDTO));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);

    }

    @PutMapping("/{id}")
    public ResponseEntity< UserComumDTO > update(@PathVariable Long id, @RequestBody UserComumDTO userComumDTO) {
        
        userComumDTO.setId(id);
        userComumService.update(userComumService.fromDTO(userComumDTO));

        return ResponseEntity.ok().body(userComumDTO);

    } 

    @DeleteMapping("/{id}")
    public ResponseEntity< UserComum > delete(@PathVariable Long id) {
        
        UserComum userComum = userComumService.findById(id);

        if(userComum.getCarteira() != null) {
            throw new DeleteAssociationException("Carteira associada");
        }

        userComumService.delete(id);

        return ResponseEntity.noContent().build(); 

    }

}
