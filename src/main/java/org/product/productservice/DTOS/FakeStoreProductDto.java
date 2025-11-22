package org.product.productservice.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
public class FakeStoreProductDto implements Serializable {

    private UUID id;
    private String title;
    private int price;
    private String description;
    private String category;
    private String image;

}



