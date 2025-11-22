package org.product.productservice;

//import org.product.productservice.inheritanceRelationships.mappedSuperClass.Mentor;
//import org.product.productservice.inheritanceRelationships.mappedSuperClass.MentorRepository;
import org.product.productservice.inheritanceRelationships.tablePerClass.*;
import org.product.productservice.models.Category;
import org.product.productservice.models.Order;
import org.product.productservice.models.Price;
import org.product.productservice.models.Product;
import org.product.productservice.repositories.CategoryRepository;
import org.product.productservice.repositories.PriceRepository;
import org.product.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    ProductServiceApplication(ProductRepository productRepository, CategoryRepository categoryRepository,
                              PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }




//    MentorRepository mentorRepository;
//    UserRepository userRepository;
//    StudentRepository studentRepository;
//
//    ProductServiceApplication( @Qualifier("TCPMentorRepository") MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//            Category category = new Category();
//            category.setName("Apple Products");
//            Category savedCategory = categoryRepository.save(category);
//
//            List<Product> products = category.getProducts();
//            category.getId()

//            Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("726b6c58-5517-4546-8282-f125c066449f"));
//            if(optionalCategory.isEmpty()) {
//                throw new RuntimeException("Category not found");
//            }
//
//            Category category = optionalCategory.get();
//
//            Product product = new Product();
////            product.setCategory(savedCategory);
//            product.setCategory(category);
//            product.setName("Iphone");
//            product.setDescription("Iphone");
//
//            Product savedProduct =  productRepository.save(product);

//                Price price = new Price();
//                price.setCurrency("INR");
//                price.setPrice(100000);
//                Price savedPrice = priceRepository.save(price);
//
//                Category category = new Category();
//                category.setName("Apple ");
//                Category savedCategory =  categoryRepository.save(category);
//
//                Product product = new Product();
//                product.setCategory(savedCategory);
//                product.setPrice(savedPrice);
//                product.setName("Apple Watch");
//                product.setDescription("Best Apple Watch");
//                productRepository.save(product);

//               List<Product> products = productRepository.findAllByPrice_PriceGreaterThan(5000);
//        System.out.println(products);


    }

    //    @Override
//    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Mentor");
//        mentor.setEmail("mentor@c.xom");
//        mentor.setAvgRating(4.8);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Student");
//        student.setPsp(4.5);
//        student.setEmail("abc@xyz.com");
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setName("User");
//        user.setEmail("abc@xyz.com");
//        userRepository.save(user);
//
//        List<User> users =  userRepository.findAll();
//
//        for (User user1 : users) {
//            System.out.println(user1);
//        }

//    }
}
