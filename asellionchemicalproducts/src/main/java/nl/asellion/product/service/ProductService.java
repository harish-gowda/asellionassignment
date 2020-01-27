package nl.asellion.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import nl.asellion.product.exception.ResourceNotFoundException;
import nl.asellion.product.model.Product;

@Service
public interface ProductService {

	List<Product> listAllProducts();

	Product getProductById(long id) throws ResourceNotFoundException;

	Product saveProduct(Product product);
	
	Product updateProduct(long id,Product product) throws ResourceNotFoundException;

}
