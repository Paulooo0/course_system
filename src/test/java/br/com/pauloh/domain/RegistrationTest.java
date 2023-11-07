package br.com.pauloh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;

import org.junit.After;
import org.junit.Test;

import br.com.pauloh.dao.IRegistrationDAO;
import br.com.pauloh.dao.RegistrationDAO;

public class RegistrationTest {
    private IRegistrationDAO regDAO;
    // TODO: relation with Student and Course
    
    public RegistrationTest() {
        regDAO = new RegistrationDAO();
    }

    @After
    public void tearDown() {
        regDAO.findAll().forEach(registration -> regDAO.delete(registration));
    }

    @Test
    public void createRegistrationTest() {
        Registration reg = new Registration();

        reg.setCode("A1");
        reg.setRegistrationDate(Instant.now());
        reg.setValue(2000.0);
        reg.setStatus("ATIVA");
        reg = regDAO.create(reg);

        assertNotNull(reg);
        assertNotNull(reg.getId());
    }

    @Test
    public void findByIdRegistrationTest() {
        Registration reg = new Registration();

        reg.setCode("A2");
        reg.setRegistrationDate(Instant.now());
        reg.setValue(2000.0);
        reg.setStatus("ATIVA");
        reg = regDAO.create(reg);

        Registration findById = regDAO.read(reg.getId());

        assertEquals(findById.getId(), reg.getId());
    }

    @Test
    public void updateRegistrationTest() {
        Registration reg = new Registration();

        reg.setCode("A3");
        reg.setRegistrationDate(Instant.now());
        reg.setValue(2000.0);
        reg.setStatus("ATIVA");
        reg = regDAO.create(reg);

        reg.setCode("A4");
        reg.setRegistrationDate(Instant.now());
        reg.setValue(2000.0);
        reg.setStatus("ATIVA");
        reg = regDAO.update(reg);

        assertNotNull(reg);
        assertNotNull(reg.getId());
    }

    @Test
    public void deleteRegistrationTest() {
        Registration reg = new Registration();

        reg.setCode("A5");
        reg.setRegistrationDate(Instant.now());
        reg.setValue(2000.0);
        reg.setStatus("ATIVA");
        reg = regDAO.create(reg);

        regDAO.delete(reg);

        Registration deletedRegistration = regDAO.read(reg.getId());
        assertNull(deletedRegistration);
    }

    @Test
    public void findAllRegistrationTest() {
        Registration reg = new Registration();

        reg.setCode("A6");
        reg.setRegistrationDate(Instant.now());
        reg.setValue(2000.0);
        reg.setStatus("ATIVA");
        reg = regDAO.update(reg);

        Registration reg2 = new Registration();

        reg2.setCode("A7");
        reg2.setRegistrationDate(Instant.now());
        reg2.setValue(2000.0);
        reg2.setStatus("ATIVA");
        reg2 = regDAO.create(reg2);

        assertEquals(2, regDAO.findAll().size());
    }
}