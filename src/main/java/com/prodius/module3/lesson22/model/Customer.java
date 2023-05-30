package com.prodius.module3.lesson22.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 30)
    private String name;

    private int age;

    private LocalDateTime created;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Order order;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Visit> visits;

    @ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Platform> platforms;

    public void setVisits(final Set<Visit> visits) {
        this.visits = visits;
        visits.forEach(visit -> visit.setCustomer(this));
    }

    public void setPlatforms(final Set<Platform> platforms) {
        this.platforms = platforms;
        platforms.forEach(platform -> {
                    final Set<Customer> customers = Objects.requireNonNullElse(platform.getCustomers(), new HashSet<>());
                    customers.add(this);
                    platform.setCustomers(customers);
                }
        );
    }

    @PrePersist
    public void prePersist() {
        if (created == null) {
            created = LocalDateTime.now();
        }
    }
}
