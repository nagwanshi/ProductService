package org.product.productservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String category;
    private String image;
}
