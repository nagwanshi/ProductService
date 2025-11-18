package org.product.productservice.inheritanceRelationships.tablePerClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name="tcp_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
}
