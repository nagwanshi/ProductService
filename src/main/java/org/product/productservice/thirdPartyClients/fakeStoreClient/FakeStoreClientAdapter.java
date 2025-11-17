package org.product.productservice.thirdPartyClients.fakeStoreClient;

import org.product.productservice.DTOS.FakeStoreProductDto;
import org.product.productservice.DTOS.GenericProductDto;
import org.product.productservice.exceptions.ProductNotFoundException;
import org.product.productservice.thirdPartyClients.ThirdPartyClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClientAdapter  {
    private RestTemplateBuilder restTemplateBuilder;

//    @Value didn't work

    private String baseUrl;

    @Value("${fakeStore.api.path.products}")
    private String pathForProducts;
//    private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";
//    private final String genericProductsUrl = "https://fakestoreapi.com/products" private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private final String genericProductsUrl;
    private final String specificProductUrl;

    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder, @Value("${fakeStore.api.url}")  String baseUrl, @Value("${fakeStore.api.path.products}") String pathForProducts ) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.genericProductsUrl = baseUrl + pathForProducts;
        this.specificProductUrl = baseUrl + pathForProducts+ "/{id}";
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


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
//        System.out.println("Response Status Code: " + responseEntity.getStatusCode());
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("The product with id" + id + " doesn't exists");
        }
        return responseEntity.getBody();

    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
//     The following line won't work. WE can't do this in Java . Why?
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(genericProductsUrl, FakeStoreProductDto[].class);

        return List.of(responseEntity.getBody());

    }




    public void updateProductById(Long id) {
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto deleteProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        if(responseEntity == null){
            throw new ProductNotFoundException("Product with id " + id + "Does not exists" );
        }

        return responseEntity.getBody();
    }
}
