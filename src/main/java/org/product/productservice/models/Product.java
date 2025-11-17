package org.product.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
        private String name;
        private String description;
        private String image;
        private int price;
        @ManyToOne
        private Category category;
}


/*
* Cardinality many to one, one product can have one category, many prodcuts can be of one category
* */