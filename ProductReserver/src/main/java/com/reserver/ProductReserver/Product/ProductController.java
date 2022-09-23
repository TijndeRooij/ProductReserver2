package com.reserver.ProductReserver.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
@RequestMapping(path="/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{sorter}")
    public List<Product> getSortedProducts(@PathVariable String sorter){
        return productService.sortProductList(sorter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product productToRemove = productService.getProductById(id);
        product.setQuantity(productToRemove.getQuantity() - 1);

        productService.update(productToRemove, product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/CreateProduct")
    public ResponseEntity<Void> CreateProduct(@RequestBody Product product) {
        productService.createProduct(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
