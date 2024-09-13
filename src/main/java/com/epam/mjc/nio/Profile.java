package com.epam.mjc.nio;

import java.util.Objects;

public class Profile {
    private final String name;
    private final Integer age;
    private final String email;
    private final Long phone;

    public Profile(String name, Integer age, String email, Long phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
    // getters only
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profile{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Profile profile = (Profile) o;
    return Objects.equals(name, profile.name) &&
           Objects.equals(age, profile.age) &&
           Objects.equals(email, profile.email) &&
           Objects.equals(phone, profile.phone);
}


    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getEmail(), getPhone());
    }
}
