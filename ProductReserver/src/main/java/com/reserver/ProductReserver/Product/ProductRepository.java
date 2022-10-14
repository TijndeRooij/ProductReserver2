package com.reserver.ProductReserver.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("update Product u set u.name = :name, u.discription = :discription, u.quantity = :quantity, u.guideLines = :guideLines where u.id = :id")
    void updateProduct(
            @Param("id") Integer id,
            @Param("name") String name,
            @Param("discription") String discription,
            @Param("quantity") Integer quantity,
            @Param("guideLines") String guideLines
    );
}

