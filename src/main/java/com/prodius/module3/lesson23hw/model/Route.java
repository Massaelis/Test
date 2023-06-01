package com.prodius.module3.lesson23hw.model;

import com.prodius.module3.lesson23hw.model.modelTransport.Transport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@ToString
public class Route {
    @Id
    @ToString.Exclude
    private String id;

    private int distance;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Transport transport;

    @ManyToOne
    private Company company;
}