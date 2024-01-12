package com.excelr.mainpackage.model;


import com.excelr.mainpackage.validation.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    @NotBlank(message = "First name is required")
    private String firstName;
    @Column(name="last_name")
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Column(name="department")
    @NotBlank(message = "Department is required")
    private String department;
    @Column(name="email_id")
    @Email(message = "Invalid email format")
    private String emailId;
    @Column(name="address")
    private String address;
    @Column(name="salary")
    @NotNull(message = "salary is required")
    private double salary;
    @Column(name="phone_number")
    @PhoneNumber
    private String phoneNumber;

    @Column(name="date_of_joining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String department,String emailId, String address, double salary, String phoneNumber, Date dateOfJoining) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.emailId=emailId;
        this.address = address;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.dateOfJoining = dateOfJoining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}

