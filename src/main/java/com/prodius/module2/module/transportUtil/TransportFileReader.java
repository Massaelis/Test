package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Type;
import com.prodius.module2.module.vehicle.Vehicle;
import com.prodius.module2.module.vehicle.typeVehicle.Bicycle;
import com.prodius.module2.module.vehicle.typeVehicle.Car;
import com.prodius.module2.module.vehicle.typeVehicle.Motorcycle;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransportFileReader {
    private static final String NOTES_FILE = "src/main/resources/vehicle.txt";

    public static void saveVehicleToFile(List<Vehicle> transportList) {
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(NOTES_FILE))) {
            for (Vehicle note : transportList) {
                final Type type = note.getType();
                final int numberOfWheels = note.getNumberOfWheels();
                final String brand = note.getBrand();
                final int yearOfIssue = note.getYearOfIssue();
                final double maxSpeed = note.getMaxSpeed();
                writer.write(String.format("Type: %s, Wheels: %s, Brand: %s, Year: %s, Max speed: %s%n",
                type, numberOfWheels, brand, yearOfIssue, maxSpeed));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readeVehicleFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> parts = Arrays.stream(new String[]{line})
                        .flatMap(line2 -> Stream.of(line2.split(", ")))
                        .flatMap(line2 -> Stream.of(line2.split(": "))).toList();
                final Type type = Type.valueOf(parts.get(1));
                final int numberOfWheels = Integer.parseInt(parts.get(3));
                final String brand = parts.get(5);
                final int yearOfIssue = Integer.parseInt(parts.get(7));
                final double maxSpeed = Double.parseDouble((parts.get(9)));

                Vehicle note = null;
                switch (type){
                    case CAR -> note = new Car( numberOfWheels, brand, yearOfIssue, maxSpeed);
                    case BICYCLE -> note = new Bicycle( numberOfWheels, brand, yearOfIssue, maxSpeed);
                    case MOTORCYCLE -> note = new Motorcycle( numberOfWheels, brand, yearOfIssue, maxSpeed);
                }
                System.out.println(note);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
