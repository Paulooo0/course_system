package br.com.pauloh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.pauloh.dao.ClientDAO;
import br.com.pauloh.dao.generic.IGenericDAO;

public class ClientTest {
    IGenericDAO<Client> clientDAO = new ClientDAO();
    
    @Test
    public void createClientTest() {
        Client client = new Client();

        client.setCode("CLI1");
        client.setName("Paulo");
        client.setLastName("Henrique");
        client.setAge(21);

        clientDAO.create(client);
        
        assertNotNull(client);
    }

    @Test
    public void readClientTest() {
        Client client = new Client();

        client.setCode("CLI2");
        client.setName("Paulo");
        client.setLastName("Henrique");
        client.setAge(21);
        clientDAO.create(client);

        Client read = clientDAO.read(client.getId());

        assertEquals(read.getCode(), client.getCode());
    }

    @Test
    public void deleteClientTest() {
        // Client client = new Client();

        // client.setCode("CLI1");
        // client.setName("Paulo");
        // client.setLastName("Henrique");
        // client.setAge(21);
        // clientDAO.create(client);
    }
}
