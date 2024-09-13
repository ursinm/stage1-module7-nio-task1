package com.epam.mjc.nio;

import java.util.Objects;

public class Profile {
    private String name;
    private int age;
    private String email;
    private String phone;

    // Constructors
    public Profile() {}

    public Profile(String name, int age, String email, String phone) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhone(phone);
    }

    // Getters and setters with validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Add regex or similar check for email validation
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        // Add phone validation if necessary
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return age == profile.age &&
               Objects.equals(name, profile.name) &&
               Objects.equals(email, profile.email) &&
               Objects.equals(phone, profile.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email, phone);
    }

    @Override
    public String toString() {
        return "Profile{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               ", phone='" + phone + '\'' +
               '}';
    }
}
