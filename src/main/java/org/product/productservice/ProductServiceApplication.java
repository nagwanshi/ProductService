package org.product.productservice;

import org.product.productservice.inheritanceRelationships.mappedSuperClass.Mentor;
import org.product.productservice.inheritanceRelationships.mappedSuperClass.MentorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    MentorRepository mentorRepository;

    ProductServiceApplication( @Qualifier("MSMentorRepository") MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("Mentor");
        mentor.setEmail("mentor@c.xom");
        mentor.setAvgRating(4.8);
        mentorRepository.save(mentor);
    }
}
