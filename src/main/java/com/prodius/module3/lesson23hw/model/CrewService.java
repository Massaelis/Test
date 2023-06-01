package com.prodius.module3.lesson23hw.model;

import com.prodius.module3.lesson23hw.model.modelTransport.Transport;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class CrewService {
    @Id
    @ToString.Exclude
    public String id;

    public String name;

    public int countCrew;

    @ManyToMany(mappedBy = "crewService")
    public Set<Transport> transport = new LinkedHashSet<>();
}