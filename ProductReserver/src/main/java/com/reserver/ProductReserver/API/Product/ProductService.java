package com.reserver.ProductReserver.API.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
    List<Product> productsSortedByName = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    public void createProduct(Product product){
        Product productToCreate = new Product();
        productToCreate.setName(product.getName());
        productToCreate.setDiscription(product.getDiscription());
        productToCreate.setRating(5);
        productToCreate.setQuantity(product.getQuantity());
        productToCreate.setGuideLines(product.getGuideLines());
        repo.save(productToCreate);
    }

    public void update(Product productToUpdate, Product updatedProduct){
        repo.updateProduct(productToUpdate.getId(), updatedProduct.getName(), updatedProduct.getDiscription(), updatedProduct.getQuantity(), updatedProduct.getGuideLines());
        System.out.println(updatedProduct.getName());
    }

    public Product deleteProduct(Integer id){
        for(Product product : products){
            if (product.getId().equals(id)){
                repo.delete(product);
                return product;
            }
        }
        return null;
    }

    public void getProducts(){
        products = repo.findAll();
    }

    public Product getProductById(Integer id){
        for (Product product : products){
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductByName(String name){
        productsSortedByName.clear();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                productsSortedByName.add(product);
            }
        }
        return productsSortedByName;
    }


    public List<Product> sortProductList(String sorter){
        for (int j = 0; j <= products.size() - 2; j++)
        {
            for (int i = 0; i <= products.size() - 2; i++)
            {
                if ((Objects.equals(sorter, "id") && products.get(i).getId() > products.get(i + 1).getId())||
                        (Objects.equals(sorter, "rating") && products.get(i).getRating() > products.get(i + 1).getRating())||
                        (Objects.equals(sorter, "quantity") && products.get(i).getQuantity() > products.get(i + 1).getQuantity()))
                {
                    Collections.swap(products, i, i + 1);
                }
            }
        }
        removeDuplicates();
        return products;
    }

    private void removeDuplicates() {
        for (int j = 0; j <= products.size() - 2; j++)
        {
            for (int i = 0; i <= products.size() - 2; i++)
            {
                if (products.get(i).getId().equals(products.get(i + 1).getId())){
                    products.remove(products.get(i));
                }
            }
        }
    }
}
