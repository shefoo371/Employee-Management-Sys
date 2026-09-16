package com.myProject.Employee.Management.System.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "first_name" , nullable = false,length = 100)
    private String firstName;

    @Column(name = "last_name" , nullable = false,length = 100)
    private String lastName;

    @Column(name = "email" , nullable = false,unique = true)
    private String email;

    @Column(name = "phone" , nullable = false)
    private String phoneNumber;

    @Column(name = "date" , nullable = false)
    private LocalDate hireDate;

    @Column(name = "pos")
    private String position;

    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JoinColumn(name = "dpID", nullable = false)
    private Department department;

    public UUID getDepartment() {
        return department.getId();
    }

}
