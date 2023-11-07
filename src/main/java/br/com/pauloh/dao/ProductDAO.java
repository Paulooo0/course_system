package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Product;

public class ProductDAO extends GenericDAO<Product> implements IProductDAO {
    public ProductDAO() {
        super(Product.class);
        new GenericDAO<>(Product.class);
    }
}
