package org.product.productservice.services;

import org.product.productservice.DTOS.FakeStoreProductDto;
import org.product.productservice.DTOS.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;

    private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private final String genericProductsUrl = "https://fakestoreapi.com/products";

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        //       Convert FakeStoreProductDto to GenericProductDto
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto>  responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
//        System.out.println("Response Status Code: " + responseEntity.getStatusCode());
        return convertToGenericProductDto(responseEntity.getBody());

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
     RestTemplate restTemplate = restTemplateBuilder.build();
//     The following line won't work. WE can't do this in Java . Why?
     ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductsUrl, FakeStoreProductDto[].class);
     List<GenericProductDto> products = new ArrayList<>();
     List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
     for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {

         products.add(convertToGenericProductDto(fakeStoreProductDto));
     }

     return products;
    }



    @Override
    public void updateProductById(Long id) {
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return convertToGenericProductDto(responseEntity.getBody());
    }
}
