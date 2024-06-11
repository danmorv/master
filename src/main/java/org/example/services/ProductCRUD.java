package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductCRUD implements ProductServices<ProductDto>{
    private final ProductRepository productRepository;

    @Override
    public ProductDto getById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow();
        return mapToDto(product);

    }

    @Override
    public Collection<ProductDto> getAll() {
       return productRepository.findAll()
                .stream()
                .map(ProductCRUD::mapToDto)
                .toList();
    }

    @Override
    public void create(ProductDto productDto) {
        Collection<ProductDto> collection = productRepository.findAll()
                .stream()
                .map(ProductCRUD::mapToDto)
                .toList();
        int sizeRepository = collection.size();
        for (int i = 1; i <= sizeRepository; i++) {
            if (productRepository.findById(i).get().getProductName().equals( productDto.getProductName())) {
                update(productDto);
            }
        }
        Product product = mapToEntity(productDto);
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(ProductDto productDto) {
        Collection<ProductDto> collection = productRepository.findAll()
                .stream()
                .map(ProductCRUD::mapToDto)
                .toList();
        int sizeRepository = collection.size();
        for (int i = 1; i <= sizeRepository; i++) {
            if (productRepository.findById(i).get().getProductName().equals(productDto.getProductName())) {
                Product product = productRepository.findById(i).orElseThrow();
                product.setQuantity(product.getQuantity() + productDto.getQuantity());
                productRepository.save(product);
            }
        }
    }

    public static ProductDto mapToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setQuantity(product.getQuantity());
        productDto.setDelivery(LocalDate.now());
        return productDto;

    }
    public static Product mapToEntity(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setQuantity(productDto.getQuantity());
        product.setDelivery(LocalDate.now());
        return product;
    }
}
