package nl.asellion.product;

import nl.asellion.product.model.Product;
import nl.asellion.product.repository.ProductRepository;
import nl.asellion.product.service.ProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProductById() {
      // ProductService productService = new ProductService(productRepository);
        Product product = new Product();
        product.setId(1);
        product.setName("Test");
        productRepository.save(product);

        when(productRepository.findById(1).get()).thenReturn(product);

        //Product product1 = productService.getProductById(1);
        //assertThat(product1).isEqualTo(product);
    }
}
