package com.trunghuynh.validateregisterform.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private int age;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        String number = user.getPhoneNumber();
        String email = user.getEmail();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        int age = user.getAge();

        //Phone validation
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "number.empty");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("phoneNumber", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("phoneNumber", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*)")) {
            errors.rejectValue("phoneNumber", "number.matches");
        }

        //Email validation
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (email.length() > 99 || email.length() < 5) {
            errors.rejectValue("email", "email.length");
        }
        if (!email.matches("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$")) {
            errors.rejectValue("email", "email.matches");
        }

        //firstname vs lastname
        ValidationUtils.rejectIfEmpty(errors, "firstName", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "name.empty");
        if (firstName.length() > 99 || firstName.length() < 5) {
            errors.rejectValue("firstName", "firstname.length");
        }
        if (lastName.length() > 99 || lastName.length() < 5) {
            errors.rejectValue("lastName", "lastname.length");
        }

        //Age
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age < 18) {
            errors.rejectValue("age", "age.too-young");
        }
    }


    public User() {
    }

    public User(Long id, String email, String phoneNumber, String firstName, String lastName, int age) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
