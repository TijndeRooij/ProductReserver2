import com.reserver.ProductReserver.API.Product.Product;
import com.reserver.ProductReserver.API.Product.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceTests {
    private final ProductService productService;

    public ProductServiceTests(ProductService productService) { this.productService = productService; }

    @Test
    @DisplayName("Should sort products in list")
    void shouldSortProductsInList() {


        productService.sortProductList("id");
    }

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "One", "Fist test product", 5, "1-2", 5, LocalDate.now()),
            new Product(2, "Two", "Second test product", 4, "1-3", 4, LocalDate.now()),
            new Product(3, "Third", "Third test product", 3, "1-4", 3, LocalDate.now())
    ));
}
