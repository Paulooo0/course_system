package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Registration;

public class RegistrationDAO extends GenericDAO<Registration> implements IRegistrationDAO {
    public RegistrationDAO() {
        super(Registration.class);
        new GenericDAO<>(Registration.class);
    }
}
