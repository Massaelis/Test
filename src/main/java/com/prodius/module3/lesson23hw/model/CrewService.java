package com.prodius.module3.lesson23hw.model;

import com.prodius.module3.lesson23hw.model.modelTransport.Transport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class CrewService {
    @Id
    @ToString.Exclude
    private String id;

    private String name;

    private int countCrew;

    @ManyToMany(mappedBy = "crewService")
    private Set<Transport> transport = new LinkedHashSet<>();
}