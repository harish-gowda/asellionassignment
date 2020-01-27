package nl.asellion.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import nl.asellion.product.model.Product;
import nl.asellion.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class productIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByProductName() {
        Product product = new Product();
        product.setName("testName");
        product.setCurrentprice(BigDecimal.valueOf(1000));
        productRepository.save(product);

        Product findByid = productRepository.findById((int)1).get();

        assertThat(findByid).hasFieldOrPropertyWithValue("name", "testName");
    }
} 
