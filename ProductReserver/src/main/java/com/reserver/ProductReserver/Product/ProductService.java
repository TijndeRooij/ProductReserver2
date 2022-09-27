package com.reserver.ProductReserver.Product;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1,"Clay", "Play-do", 3, "1-2-3", 5),
        new Product(2, "Sand", "SandO", 9, "1-3-4", 2),
        new Product(3, "Spoon", "Spooonnn", 100, "1", 3)
    ));

    public Product getProductById(Integer id){
        for (Product product : products){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void createProduct(Product product){
        product.setId(products.size() + 1);
        products.add(product);
    }

    public void update(Product productToRemove, Product productToAdd){
        products.remove(productToRemove);
        products.add(productToAdd);
    }

    public List<Product> sortProductList(String sorter){
        for (int j = 0; j <= products.size() - 2; j++)
        {
            for (int i = 0; i <= products.size() - 2; i++)
            {
                if (Objects.equals(sorter, "id") && products.get(i).getId() > products.get(i + 1).getId())
                {
                    System.out.println("id");
                    Collections.swap(products, i, i + 1);
                }
                else if (Objects.equals(sorter, "rating") && products.get(i).getRating() > products.get(i + 1).getRating())
                {
                    System.out.println("rating");
                    Collections.swap(products, i, i + 1);
                }
                else if (Objects.equals(sorter, "quantity") && products.get(i).getQuantity() > products.get(i + 1).getQuantity())
                {
                    System.out.println("quantity");
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
                if (products.get(i).getId() == products.get(i + 1).getId()){
                    products.remove(products.get(i));
                }
            }
        }
    }
}
