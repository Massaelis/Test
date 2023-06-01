package com.prodius.module3.lesson23hw.model;

import com.prodius.module3.lesson23hw.model.modelTransport.Transport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Route {
    @Id
    @ToString.Exclude
    public String id;

    public int distance;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "transport_id")
    public Transport transport;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    public Company company;
}