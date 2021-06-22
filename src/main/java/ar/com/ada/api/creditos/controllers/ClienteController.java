package ar.com.ada.api.creditos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController{
    @Autowired
    ClienteService service;

//Hay que hacer los mismos metodos que en service porque
//services se puede conectar con el repo pero no con el exterior
//mientras que los controllers si con el exterior pero no con el repo
//de esta forma logramos que llegue la info de los repos al exterior de la app
    
    //esto hace que cuando alguien ponga en el URL eso (la ruta)
    //haga lo que dice en el metodo de abajo
    //El get hace referencia a lo que vimos que hacen las apis
    //Lo que ponemos en el postman
    //En este caso traer algo
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> traerTodos(){
        return ResponseEntity.ok(service.traerTodos()); //esto hace que lo que vea el cliente si todo esta ok sea la lista
        //esto va al service y trae todo 
        //que su vez el service lo trae del repo
    }
    //aca como crea algo, es decir que lo postea
    //se pone post
    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        service.crearCliente(cliente);
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.message = "El cliente fue creado con exito";
        return ResponseEntity.ok(respuesta);
    }
}