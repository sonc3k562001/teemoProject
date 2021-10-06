package com.example.project.serviced;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getById(int id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
