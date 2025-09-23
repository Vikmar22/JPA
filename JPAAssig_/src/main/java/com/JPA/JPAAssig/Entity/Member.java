package com.JPA.JPAAssig.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private int dateOfBirth;

    public Member(int id, String firstName, String lastName, String email, String address, String phone, int dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;

    }


}
