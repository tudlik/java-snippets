package cz.jty.restApi_advanced;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.jty.restApi_advanced.model.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;


@SpringBootTest
@AutoConfigureMockMvc
class CreateNewProductTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createNewProductSuccess() throws Exception{

    }
}
