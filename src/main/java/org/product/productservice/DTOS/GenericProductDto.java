package org.product.productservice.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenericProductDto implements Serializable {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String category;
    private String image;
}
