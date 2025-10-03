package com.JPA.JPAAssig;

import com.JPA.JPAAssig.DAO.AdminDAO;
import com.JPA.JPAAssig.Entity.Address;
import com.JPA.JPAAssig.Entity.Member;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

    @Bean
    public CommandLineRunner init(AdminDAO adminDAO) {
        return args -> {
            Address address = new Address("övre", "sund", "865");
            Member member = new Member("vee", "marr", "viktor.markstrom@outlook.com", address, "0706107574", "0204223077");
            adminDAO.saveMember(member);
            Address address2 = new Address("stora vägen", "gothenburg", "41256");
            Member member2 = new Member("emma", "johansson", "emma.johansson@example.com", address2, "0706234567", "15051992");
            adminDAO.saveMember(member2);
            Address address3 = new Address("södra torget", "malmö", "21134");
            Member member3 = new Member("lina", "berg", "lina.berg@example.com", address3, "0706345678", "23081985");
            adminDAO.saveMember(member3);
            Address address4 = new Address("västra parken", "uppsala", "75320");
            Member member4 = new Member("erik", "andersson", "erik.andersson@example.com", address4, "0706456789", "05031988");
            adminDAO.saveMember(member4);
            Address address5 = new Address("östra allé", "lund", "22224");
            Member member5 = new Member("sara", "nilsson", "sara.nilsson@example.com", address5, "0706567890", "12071991");
            adminDAO.saveMember(member5);


        };




    }
}


