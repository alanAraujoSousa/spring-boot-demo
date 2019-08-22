package com.example.demo.commons.beans;

import com.example.demo.commons.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "The name of client cannot be null")
    @Size(min = 3, max = 30)
    @Column(nullable = false)
    private String name;

    @NotNull(message = "The gender of client cannot be null")
    @Enumerated
    @Column(nullable = false)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
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
