package ar.com.ada.api.creditos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController{
    @Autowired
    ClienteService service;

//Hay que hacer los mismos metodos que en service porque
//services se puede conectar con el repo pero no con el exterior
//mientras que los controllers si con el exterior pero no con el repo
//de esta forma logramos que llegue la info de los repos al exterior de la app

    public List<Cliente> traerTodos(){
        return service.traerTodos();
        //esto va al service y trae todo 
        //que su vez el service lo trae del repo
    }

    public void crearCliente(Cliente cliente){
        service.crearCliente(cliente);
    }
}