package org.product.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity

public class Price extends BaseModel{

    private String currency;
    private double price;
}
