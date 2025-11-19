package org.product.productservice.inheritanceRelationships.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Override
    Student save(Student student);
}
