package br.com.pauloh.dao.generic;

import java.util.List;

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
    public T update(T entity) {
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

        em.close();
        emf.close();

        return entity;
    }

    @Override
    public void delete(T entity) {
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        T mergedEntity = em.merge(entity);

        em.remove(mergedEntity);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    
    @Override
    public List<T> findAll() {
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        List<T> entities = em
            .createQuery("FROM " + entityClass.getSimpleName(), entityClass)
            .getResultList();
        
        em.close();
        emf.close();

        return entities;
    }
}
