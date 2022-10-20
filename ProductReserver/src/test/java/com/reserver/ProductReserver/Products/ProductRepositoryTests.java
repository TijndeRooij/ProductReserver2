package com.reserver.ProductReserver.Products;
import static org.assertj.core.api.Assertions.assertThat;

import com.reserver.ProductReserver.API.Product.Product;
import com.reserver.ProductReserver.API.Product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repo;

    private Product Product(){
        Product product = new Product();
        product.setId(1);
        product.setName("Test");
        product.setDiscription("test");
        product.setRating(3);
        product.setQuantity(10);
        product.setGuideLines("1-2");
        return product;
    }

    @Test
    public void testCreateProduct() {
        Product product = Product();

        Product savedProduct = repo.save(product);

        Product exitProduct = entityManager.find(Product.class, savedProduct.getId());
        assertThat(product.getName()).isEqualTo(exitProduct.getName());
        assertThat(product.getQuantity()).isEqualTo(exitProduct.getQuantity());
        assertThat(product.getDiscription()).isEqualTo(exitProduct.getDiscription());
        assertThat(product.getGuideLines()).isEqualTo(exitProduct.getGuideLines());
        assertThat(product.getRating()).isEqualTo(exitProduct.getRating());
        assertThat(product.getBuyDate()).isEqualTo(exitProduct.getBuyDate());
    }
}
