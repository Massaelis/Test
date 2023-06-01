package com.prodius.module3.lesson23hw.query;

import com.prodius.module3.lesson23hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson23hw.dto.*;

import javax.persistence.EntityManager;

public class Query {
    private static final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public void infoTransportToCompany(String name) {
        ENTITY_MANAGER.createNativeQuery("SELECT transport.* , company.name  FROM transport\n" +
                        "INNER JOIN route ON route.transport_id = transport.id\n" +
                        "INNER JOIN company ON route.company_id = company.id\n" +
                        "WHERE name in (:name)", TransportDTO.class)
                .setParameter("name", name)
                .getResultList()
                .forEach(System.out::println);
    }

    public void getTransportCount(){
        ENTITY_MANAGER.createNativeQuery("SELECT crewservice.name as crewservice_name , count(transport.id) as transport_count FROM crewservice\n" +
                        "INNER JOIN transport_crewservice ON transport_crewservice.crewservice_id = crewservice.id\n" +
                        "INNER JOIN transport ON transport_crewservice.transport_id = transport.id\n" +
                        "GROUP BY name", CrewServiceDTO.class)
                .getResultList()
                .forEach(System.out::println);
    }

    public void getTransportToCompany(String dtype){
        ENTITY_MANAGER.createNativeQuery("SELECT name , dtype FROM company\n" +
                        "INNER JOIN route ON route.company_id = company.id\n" +
                        "INNER JOIN transport ON route.transport_id = transport.id\n" +
                        "WHERE dtype in (:dtype)", CompanyDTO.class)
                .setParameter("dtype", dtype)
                .getResultList()
                .forEach(System.out::println);
    }

    public void sumInTransport(){
        ENTITY_MANAGER.createNativeQuery("SELECT sum(loadcapacity) as sum_loadCapacity, sum(MaintenanceCost) as sum_maintenanceCost FROM transport", SumInTransportDTO.class)
                .getResultList()
                .forEach(System.out::println);
    }

    public void distanceRoute(String dtype){
        ENTITY_MANAGER.createNativeQuery("SELECT distance FROM route\n" +
                        "JOIN transport ON route.transport_id = transport.id\n" +
                        "WHERE dtype = (:dtype)", DistanceRouteDTO.class)
                .setParameter("dtype", dtype)
                .getResultList()
                .forEach(System.out::println);
    }
}