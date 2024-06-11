package org.example.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.services.ProductCRUD;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductCRUD productCRUD;
    @GetMapping("/{id}")
    public ProductDto getUserById(@PathVariable Integer id) {
        return productCRUD.getById(id);
    }
    @GetMapping()
    public Collection<ProductDto> getAllProduct() {
        return productCRUD.getAll();
    }
    @PostMapping()
    public void createProduct(@RequestBody ProductDto productDto) {
        productCRUD.create(productDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        productCRUD.delete(id);
    }
}
