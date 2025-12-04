package org.product.productservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.ProductServiceApplication;
import org.product.productservice.exceptions.ProductNotFoundException;
import org.product.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)

public class ProductControllerWebMVCTest {

    @MockitoBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Inject
    private ObjectMapper objectMapper;

    @Captor
    private ArgumentCaptor<Long> argumentCaptor;

    @Autowired
    private ProductController productController;

    @Test
    void testGetAllProductsEmptyList() throws Exception {
        when(productService.getAllProducts()).thenReturn(new ArrayList<>());

//        assert(productService.getAllProducts().isEmpty());

        mockMvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsValidList() throws Exception {

        List<GenericProductDto> genericProductDtos = new ArrayList<GenericProductDto>();

        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());

        when(productService.getAllProducts()).thenReturn(genericProductDtos);

//        assert(productService.getAllProducts().isEmpty());

        mockMvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }

    @Test
    void testCreateProductShouldCreateValidProduct() throws Exception {

        GenericProductDto genericProductDtoToCreate = new GenericProductDto();

        genericProductDtoToCreate.setTitle("Test Title");
        genericProductDtoToCreate.setDescription("Test Description");
        genericProductDtoToCreate.setCategory("Test Category");
        genericProductDtoToCreate.setPrice(200000);


        GenericProductDto outputGenericProductDto = new GenericProductDto();
        outputGenericProductDto.setTitle("Test Title");
        outputGenericProductDto.setDescription("Test Description");
        outputGenericProductDto.setCategory("Test Category");
        outputGenericProductDto.setPrice(200000);
        outputGenericProductDto.setId(UUID.fromString("edbbb08d-38b6-485c-b4ed-9f965f114237"));


        when(productService.createProduct(any(GenericProductDto.class))).thenReturn(outputGenericProductDto);

//        assert(productService.getAllProducts().isEmpty());

        mockMvc.perform(MockMvcRequestBuilders.post("/products").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(genericProductDtoToCreate))).
                andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(outputGenericProductDto))).
        andExpect(jsonPath("$.title", is("Test Title")));
    }


    @Test
    @DisplayName("testProductControllerCallsProductServiceWithSameID")
    void testSameInput() throws ProductNotFoundException {
//        This is a test to case to see that the product controller is passing the same id to the product service as input
        Long id = 100l;

        when(productService.getProductById(id)).thenReturn(new GenericProductDto());
        GenericProductDto genericProductDto = productController.getProductById(id);

        verify(productService).getProductById(argumentCaptor.capture());

        assertEquals(id, argumentCaptor.getValue());
    }
}
