package com.prodius.module3.lesson23hw.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Company {
    @Id
    @ToString.Exclude
    private String id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Route> route = new LinkedHashSet<>();
}