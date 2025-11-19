package org.product.productservice;

//import org.product.productservice.inheritanceRelationships.mappedSuperClass.Mentor;
//import org.product.productservice.inheritanceRelationships.mappedSuperClass.MentorRepository;
import org.product.productservice.inheritanceRelationships.tablePerClass.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    MentorRepository mentorRepository;
    UserRepository userRepository;
    StudentRepository studentRepository;

    ProductServiceApplication( @Qualifier("TCPMentorRepository") MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
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

        Student student = new Student();
        student.setName("Student");
        student.setPsp(4.5);
        student.setEmail("abc@xyz.com");
        studentRepository.save(student);

        User user = new User();
        user.setName("User");
        user.setEmail("abc@xyz.com");
        userRepository.save(user);

        List<User> users =  userRepository.findAll();

        for (User user1 : users) {
            System.out.println(user1);
        }

    }
}
