package com.example.eafinalproject.model;

import com.example.eafinalproject.RegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
    @Column(name = "student_id", nullable = false)
    private int studentId;

    @Column(name = "student_name", length = 50)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_group_id")
    private RegistrationGroup registrationGroup;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RegistrationRequest> registrationRequestList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id")
    private Registration registrations;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postal_code")),
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "province", column = @Column(name = "mailing_province")),
            @AttributeOverride(name = "country", column = @Column(name = "mailing_country"))
    })
    private Address mailingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "home_postal_code")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "province", column = @Column(name = "home_province")),
            @AttributeOverride(name = "country", column = @Column(name = "home_country"))
    })
    private Address homeAddress;

    public Student(int studentId, String name, String email, Address mailingAddress, Address homeAddress) {
        this.studentId = studentId;
        this.name = name;
        this.setEmail(email);
        this.mailingAddress = mailingAddress;
        this.homeAddress = homeAddress;
    }

    public void addRegistrationRequestList(RegistrationRequest registrationRequest) {
        this.registrationRequestList.add(registrationRequest);
    }
}