package com.prodius.module3.lesson23hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Company {
    @Id
    @ToString.Exclude
    public String id;

    public String name;

    @OneToMany(mappedBy = "company",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    public Set<Route> route = new LinkedHashSet<>();
}