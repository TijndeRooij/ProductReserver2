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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;

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
    public void getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>(Arrays.asList(Product_1, Product_2, Product_3));

        Mockito.when(productRepository.findAll()).thenReturn(products);
        //Mockito.when(productService.sortProductList("id")).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/id")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
                //.andExpect(jsonPath("$[2].name", Matchers.is("Prod_3")));
        //verify(productService, times(1)).sortProductList("id");
    }
}
