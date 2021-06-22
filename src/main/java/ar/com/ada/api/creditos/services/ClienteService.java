package ar.com.ada.api.creditos.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.repos.ClienteRepository;

// vamos a crear un service con la funcionalidad de traer todos los clientes y de grabar un cliente
@Service
public class ClienteService {

    @Autowired 
    //para que todos los objetos que vayamos a instanciar ya vengan pre intanciados de otro lugar
    ClienteRepository repository;

 public List<Cliente> traerTodos(){
     return repository.findAll();
 }

 public void crearCliente(Cliente cliente){
     repository.save(cliente); //esto guarda el cliente en el repo

 }
}