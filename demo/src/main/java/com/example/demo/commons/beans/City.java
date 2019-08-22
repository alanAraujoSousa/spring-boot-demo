package com.example.demo.commons.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class City {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "The name of city cannot be null")
    @Size(min = 3, max = 30)
    @Column(nullable = false)
    private String name;

    @Size(min = 3, max = 30)
    @NotNull(message = "The state of city cannot be null")
    @Column(nullable = false)
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id) &&
                name.equals(city.name) &&
                state.equals(city.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state);
    }
}
