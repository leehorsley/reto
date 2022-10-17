package com.mintic.Reto3.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.Reto3.Model.Client;
import com.mintic.Reto3.Repository.ClientRepository;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> client1 = clientRepository.getClient(client.getIdClient());
            if (client1.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>g= clientRepository.getClient(client.getIdClient());
            if(!g.isEmpty()){
                if(client.getEmail()!=null){                    
                    g.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    g.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    g.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    g.get().setAge(client.getAge());
                }
                clientRepository.save(g.get());
                return g.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }


    public boolean delete(int id){
        boolean flag = false;
        Optional<Client> g = clientRepository.getClient(id);
        if(g.isPresent()){
            clientRepository.delete(g.get());
        }
        return flag;
    }
}
