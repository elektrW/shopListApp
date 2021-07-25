package pl.wojciechdomagala.shoplistapp.service;

import pl.wojciechdomagala.shoplistapp.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();
    void addProduct(Product product);
    Product getProductById(long id);
    void deleteProduct(long id);
}
