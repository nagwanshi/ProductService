package org.product.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "generator_name")
    @GenericGenerator(name="generator_name", strategy = "uuid2")
    @Column(name = "id",  updatable = false, nullable = false, columnDefinition = "binary(16)")
    private UUID id;
}
