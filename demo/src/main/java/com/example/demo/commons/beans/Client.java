package com.example.demo.commons.beans;

import com.example.demo.commons.enums.Gender;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) &&
                name.equals(client.name) &&
                gender == client.gender &&
                birthDate.equals(client.birthDate) &&
                city.equals(client.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthDate, city);
    }
}
