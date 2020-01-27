package nl.asellion.product.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.asellion.product.exception.ResourceNotFoundException;
import nl.asellion.product.model.Product;
import nl.asellion.product.repository.ProductRepository;
import nl.asellion.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long id) throws ResourceNotFoundException {
		return productRepository.findById((int)id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(long id,Product product) throws ResourceNotFoundException {
		Product existingProduct = productRepository.findById((int)id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
			existingProduct = modelMapper.map(product, Product.class);
			return productRepository.save(existingProduct);
	}
}
