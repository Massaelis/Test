package com.prodius.module3.lesson23hw.model.modelTransport;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Train extends Transport {
    public int countWagon;
}