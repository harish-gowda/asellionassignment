package nl.asellion.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.asellion.product.exception.ResourceNotFoundException;
import nl.asellion.product.model.Product;
import nl.asellion.product.service.ProductService;

@RestController
@RequestMapping("/api")
@Api(value="Chemical Products", description="B2B chemical Products marketing")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "View a list of available Chemical Products", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.listAllProducts();
	}

	@ApiOperation(value = "Get an Product by Id")
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(
			@ApiParam(value = "Product id from which Product object will retrieve", required = true)
			@PathVariable(value = "id") long productId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(productService.getProductById(productId));
	}

	@ApiOperation(value = "Add an Product")
	@PostMapping("/products")
	public Product createProduct(
			@ApiParam(value = "product object store in database table", required = true)
			@Valid @RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@ApiOperation(value = "Update an product by Id")
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(
			@ApiParam(value = "product Id to update product object", required = true)
			@PathVariable(value = "id") Integer productId,
			@ApiParam(value = "Update product object", required = true)
			@Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		return ResponseEntity.ok(productService.updateProduct(productId, productDetails));
	}

}
