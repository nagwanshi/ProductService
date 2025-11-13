package org.product.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
        private String name;
        private String dsc;
        private String image;
        private int price;
        private Category category;
}
