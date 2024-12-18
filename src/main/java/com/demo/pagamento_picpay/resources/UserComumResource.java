package com.demo.pagamento_picpay.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pagamento_picpay.entities.UserComum;
import com.demo.pagamento_picpay.services.UserComumService;


@RestController
@RequestMapping(value = "/user/comum")
public class UserComumResource {

    @Autowired
    private UserComumService userComumService;

    @GetMapping
    public ResponseEntity< List<UserComum> > findAll() {
        
        return ResponseEntity.ok().body(userComumService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity< UserComum > findById(@PathVariable Long id) {
        
        return ResponseEntity.ok().body(userComumService.findById(id));

    }
    

}
