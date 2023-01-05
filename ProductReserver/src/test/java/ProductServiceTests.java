import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.reserver.ProductReserver.API.Product.Product;
import com.reserver.ProductReserver.API.Product.ProductController;
import com.reserver.ProductReserver.API.Product.ProductRepository;
import com.reserver.ProductReserver.API.Product.ProductService;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    private MockMvc mockMvcController;

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
        this.mockMvcController = MockMvcBuilders.standaloneSetup(productController).build();
    }
    //need to have JWT tokens.
    @Test
    public void getAllProductsEndPoint() throws Exception {
        List<Product> products = Arrays.asList(Product_1, Product_2, Product_3);

        given(productRepository.findAll())
                .willReturn(products);

        MvcResult mvcResult = mockMvcController.perform(MockMvcRequestBuilders
                .get("/{sorter}", "id")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        Product result = new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), Product.class);
        assertEquals(products, result);
    }

    @Test
    public void updateProductsTotalUseEndPoint() throws Exception {
        mockMvcController.perform(MockMvcRequestBuilders
            .put("/1/5)")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void createProductEndPoint() throws Exception {
        MvcResult mvcResult = mockMvcController.perform(MockMvcRequestBuilders.post("/CreateProduct").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(Product_1))).andReturn();

        assertEquals(201, mvcResult.getResponse().getStatus());
    }
}
