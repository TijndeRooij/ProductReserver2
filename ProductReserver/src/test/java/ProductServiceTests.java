import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.reserver.ProductReserver.API.Product.Product;
import com.reserver.ProductReserver.API.Product.ProductController;
import com.reserver.ProductReserver.API.Product.ProductRepository;
import com.reserver.ProductReserver.API.Product.ProductService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTests {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    Product Product_1 = new Product(1, "Prod_1", "Prod_1 Test", 5, "1-2-3", 5, LocalDate.now());
    Product Product_2 = new Product(2, "Prod_2", "Prod_2 Test", 15, "1-2-4", 10, LocalDate.now());
    Product Product_3 = new Product(3, "Prod_3", "Prod_3 Test", 20, "1-2-5", 15, LocalDate.now());

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void getAllProductsEndPoint() throws Exception {
        String sorter = "id";

//        when(productRepository.findAll()).thenReturn(Arrays.asList(Product_1, Product_2, Product_3));
        given(productService.sortProductList(sorter)).willReturn(Arrays.asList(Product_1, Product_2, Product_3));

//        List<Product> products = productService.sortProductList(sorter);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/{sorter}", sorter))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        assertEquals(3, mvcResult.getResponse().getContentLength());
    }

    @Test
    public void getAllProducts() throws Exception {
        String sorter = "id";

        when(productRepository.findAll()).thenReturn(Arrays.asList(Product_1, Product_2, Product_3));

        List<Product> products = productService.sortProductList(sorter);

        assertEquals(3, products.size());
    }


    @Test
    public void updateProductsTotalUseEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
            .put("/1/5)")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void createProductEndPoint() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/CreateProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(Product_1)))
                .andReturn();

        assertEquals(201, mvcResult.getResponse().getStatus());
    }
}
