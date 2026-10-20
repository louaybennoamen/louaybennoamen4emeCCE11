package tn.esprit.louaybennoamen4emecce11.service;

import tn.esprit.louaybennoamen4emecce11.domaine.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);

    Client update(Long id, Client client);

    void deleteById(Long id);

    Client findById(Long id);

    List<Client> findAll();
}
