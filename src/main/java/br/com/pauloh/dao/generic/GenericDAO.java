package br.com.pauloh.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T> implements IGenericDAO<T> {
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public GenericDAO() {
        
    }

    @Override
    public T create(T entity) {
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("test-proj");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return entity;
    }

    @Override
    public T read(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-proj");
        EntityManager em = emf.createEntityManager();

        T entity = em.find(entityClass, id);

        em.close();
        emf.close();

        return entity;
    }

    @Override
    public T update(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
