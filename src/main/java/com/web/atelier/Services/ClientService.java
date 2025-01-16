package com.web.atelier.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.atelier.Models.Client;
import com.web.atelier.Models.Composant;
import com.web.atelier.Models.Ordinateur;
import com.web.atelier.Repositories.ClientRepository;
import com.web.atelier.Repositories.ComposantRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // Add a composant
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    // Get All Composants
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get a composant by its id
    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getClientsByDateReparation(String date){
        return clientRepository.filterClientByDateReparation(date);
    }
   
}
