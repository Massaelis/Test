package com.prodius.module3.lesson23hw;

import com.prodius.module3.lesson23hw.modelCreator.ModelCreate;
import com.prodius.module3.lesson23hw.query.Query;

public class Main {
    public static void main(String[] args) {
        ModelCreate modelCreate = new ModelCreate();
        modelCreate.createData();

        Query query = new Query();

        System.out.println("~".repeat(10) + " 1 " + "~".repeat(10));
        query.infoTransportToCompany("MSC");

        System.out.println("~".repeat(10) + " 2 " + "~".repeat(10));
        query.getTransportCount();

        System.out.println("~".repeat(10) + " 3 " + "~".repeat(10));
        query.getTransportToCompany("Train");

        System.out.println("~".repeat(10) + " 4 " + "~".repeat(10));
        query.sumInTransport();

        System.out.println("~".repeat(10) + " 5 " + "~".repeat(10));
        query.distanceRoute("Boat");
    }
}