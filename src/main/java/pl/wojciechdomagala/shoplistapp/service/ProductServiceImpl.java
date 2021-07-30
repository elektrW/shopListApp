package pl.wojciechdomagala.shoplistapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wojciechdomagala.shoplistapp.model.Product;
import pl.wojciechdomagala.shoplistapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = null;
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        } else {
            throw new RuntimeException("Product not found for id: " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(Long productId) {
        this.productRepository.deleteById(productId);
    }
}
