package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Client;

public class ClientDAO extends GenericDAO<Client> implements IClientDAO {    
    public ClientDAO() {
        super(Client.class);
        new GenericDAO<>(Client.class);
    }
}
