package com.prodius.module3.lesson23hw.model.modelTransport;

import com.prodius.module3.lesson23hw.model.CrewService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    public String id;

    public int loadCapacity;

    public int maintenanceCost;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "transport_crewService",
            joinColumns = @JoinColumn(name = "transport_id"),
            inverseJoinColumns = @JoinColumn(name = "crewService_id"))
    public Set<CrewService> crewService = new LinkedHashSet<>();
}