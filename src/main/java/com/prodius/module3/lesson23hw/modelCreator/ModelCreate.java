package com.prodius.module3.lesson23hw.modelCreator;

import com.prodius.module3.lesson23hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson23hw.model.Company;
import com.prodius.module3.lesson23hw.model.CrewService;
import com.prodius.module3.lesson23hw.model.Route;
import com.prodius.module3.lesson23hw.model.modelTransport.Boat;
import com.prodius.module3.lesson23hw.model.modelTransport.Train;
import com.prodius.module3.lesson23hw.model.modelTransport.Transport;
import com.prodius.module3.lesson23hw.model.modelTransport.Truck;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class ModelCreate {
    public final void createData() {
        final CrewService crewService = new CrewService();
        crewService.setId("ab18d8c9-7902-449a-8d19-48a84d51478c");
        crewService.setCountCrew(10);
        crewService.setName("Speed fix");

        final CrewService crewService2 = new CrewService();
        crewService2.setId("ce6123fa-d9c4-4af3-9a67-301b4091ea09");
        crewService2.setCountCrew(20);
        crewService2.setName("Dry dock");

        final Truck truck = new Truck();
        truck.setSizeTank(20);
        truck.setId("a3be8ef1-4f60-44de-b281-266138486abf");
        truck.setLoadCapacity(20);
        truck.setMaintenanceCost(1500);
        truck.setCrewService(Set.of(crewService2));
        final HashSet<Transport> crewService2Transport = new HashSet<>();
        crewService2Transport.add(truck);

        final Train train = new Train();
        train.setCountWagon(5);
        train.setId("2142e62a-678f-42ee-87c6-01f9fa1fbf42");
        train.setLoadCapacity(100);
        train.setMaintenanceCost(1500);
        train.setCrewService(Set.of(crewService));
        final HashSet<Transport> crewServiceTransport = new HashSet<>();
        crewServiceTransport.add(train);

        final Boat boat = new Boat();
        boat.setCountCrew(20);
        boat.setId("81d4135a-cf0b-4c30-9cba-97339de9cab6");
        boat.setLoadCapacity(2000);
        boat.setMaintenanceCost(10000);
        boat.setCrewService(Set.of(crewService, crewService2));
        crewServiceTransport.add(boat);
        crewService2Transport.add(boat);

        final Route route = new Route();
        route.setId("d75dba63-1980-472e-9d2e-0d3682a09335");
        route.setDistance(1000);
        route.setTransport(train);

        final Route route2 = new Route();
        route2.setId("24f733d6-c1d2-4c1f-beb5-bbf689ee7267");
        route2.setDistance(5000);
        route2.setTransport(boat);

        final Route route3 = new Route();
        route3.setId("e4698a9c-545e-4cfe-ad59-2efafd6a5031");
        route3.setDistance(500);
        route3.setTransport(truck);

        final Company companyMsc = new Company();
        companyMsc.setId("610ee8a1-9070-4e2c-b45e-bf7d7a5739e2");
        companyMsc.setName("MSC");
        companyMsc.setRoute(Set.of(route2, route));
        route2.setCompany(companyMsc);
        route.setCompany(companyMsc);

        final Company companyUkrFerry = new Company();
        companyUkrFerry.setId("6a2bce0a-e1b7-4378-8241-75e25d941102");
        companyUkrFerry.setName("UkrFerry");
        companyUkrFerry.setRoute(Set.of(route3));
        route3.setCompany(companyUkrFerry);

        crewService.setTransport(crewServiceTransport);
        crewService2.setTransport(crewService2Transport);


        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(companyMsc);
        entityManager.persist(crewService);
        entityManager.persist(companyUkrFerry);
        entityManager.getTransaction().commit();
    }
}