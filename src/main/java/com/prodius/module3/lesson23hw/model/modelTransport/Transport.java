package com.prodius.module3.lesson23hw.model.modelTransport;

import com.prodius.module3.lesson23hw.model.CrewService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
public abstract class Transport {
    @Id
    @ToString.Exclude
    private String id;

    private int loadCapacity;

    private int maintenanceCost;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<CrewService> crewService = new LinkedHashSet<>();
}