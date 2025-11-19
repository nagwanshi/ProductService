package org.product.productservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
        private String name;
        private String description;
        private String image;

        @ManyToOne(optional = false)
        @JoinColumn(nullable = false)
        private Category category;
        @OneToOne(optional = false, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
        @JoinColumn(nullable = false)
        private Price price;
}


/*
* Cardinality many to one, one product can have one category, many prodcuts can be of one category
* */