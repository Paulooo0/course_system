package br.com.pauloh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Test;

import br.com.pauloh.dao.IProductDAO;
import br.com.pauloh.dao.ProductDAO;

public class ProductTest {
    private IProductDAO productDAO;
    
    public ProductTest() {
        productDAO = new ProductDAO();
    }
    
    @After
    public void tearDown() {
        productDAO.findAll().forEach(product -> productDAO.delete(product));
    }

    @Test
    public void createProductTest() {
        Product product = new Product();

        product.setCode("A1");
        product.setName("Curso teste");
        product.setPrice(2000.0);
        product.setCategory("teste");
        product = productDAO.create(product);

        assertNotNull(product);
        assertNotNull(product.getId());
    }

    @Test
    public void findByIdProductTest() {
        Product product = new Product();

        product.setCode("A2");
        product.setName("Curso teste");
        product.setPrice(2000.0);
        product.setCategory("teste");
        product = productDAO.create(product);

        Product findById = productDAO.read(product.getId());

        assertEquals(findById.getId(), product.getId());
    }

    @Test
    public void updateProductTest() {
        Product product = new Product();

        product.setCode("A3");
        product.setName("Curso teste");
        product.setPrice(2000.0);
        product.setCategory("teste");
        product = productDAO.create(product);

        assertNotNull(product);
        assertNotNull(product.getId());

        product.setCode("A4");
        product.setName("Curso teste");
        product.setPrice(2000.0);
        product.setCategory("teste");
        product = productDAO.update(product);

        assertNotNull(product);
        assertNotNull(product.getId());
    }

    @Test
    public void deleteProductTest() {
        Product product = new Product();

        product.setCode("A5");
        product.setName("Curso teste");
        product.setPrice(2000.0);
        product.setCategory("teste");
        product = productDAO.create(product);

        productDAO.delete(product);

        Product deletedProduct = productDAO.read(product.getId());
        assertNull(deletedProduct);
    }

    @Test
    public void findAllProductTest() {
        Product product = new Product();

        product.setCode("A6");
        product.setName("Curso teste");
        product.setPrice(2000.0);
        product.setCategory("teste");
        product = productDAO.create(product);

        Product product2 = new Product();

        product2.setCode("A7");
        product2.setName("Curso teste");
        product2.setPrice(2000.0);
        product2.setCategory("teste");
        product2 = productDAO.create(product2);

        assertEquals(2, productDAO.findAll().size());
    }
}
