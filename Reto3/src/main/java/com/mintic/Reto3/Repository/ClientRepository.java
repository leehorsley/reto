package com.mintic.Reto3.Repository;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Repository.Crud.ClientCrudRepository;


@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
    
    /**public Client setInsert(Client client){
        boolean bParaGrabar = true;
        
        if (client.getName() == null)
            bParaGrabar = false;
        
        if (client.getEmail() == null)
            bParaGrabar = false;

        if (client.getPassword()== null)
            bParaGrabar = false;

        if (client.getAge()== null)
            bParaGrabar = false;
        
        if (bParaGrabar == true){
            return clientCrudRepository.save(client);
        }
        else
            return null;
    }
    
    private Client clientExists(Integer id){
        Optional <Client> obj = clientCrudRepository.findById(id);
        Client miobj;
        if (obj.isEmpty() == true)
            miobj = null;
        else{
            miobj = obj.get();
        }
        return miobj;
    }
    
    public Client setUpdate(Client client){
        boolean bParaGrabar = true;
        
        Client miobj = clientExists(client.getIdClient());
        if (miobj != null){
            if (client.getName() != null)
                miobj.setName(client.getName());

            if (client.getEmail() != null)
                miobj.setEmail(client.getEmail());

            if (client.getPassword()!= null)
                miobj.setPassword(client.getPassword());

            if (client.getAge()!= null)
                miobj.setAge(client.getAge());
            
            return clientCrudRepository.save(miobj);
        }
        else{
            return null;
        }
    }
    public void setDelete(Integer idClient){
        Client client = clientExists(idClient);
        if (client != null)
            clientCrudRepository.deleteById(idClient);
    }
    */
}
