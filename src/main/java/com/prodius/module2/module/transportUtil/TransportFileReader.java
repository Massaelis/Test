package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Type;
import com.prodius.module2.module.vehicle.Vehicle;

import java.io.*;
import java.util.List;

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
//                writer.write(String.format("Type: %s, Wheels: %s, Brand: %s, Year: %s, Max speed: %s%n",
//                type, numberOfWheels, brand, yearOfIssue, maxSpeed));
                writer.write(String.format("%s| %s| %s| %s| %s%n", type, numberOfWheels, brand, yearOfIssue, maxSpeed));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readeVehicleFromFile() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split("\\| ");
                final Type type = Type.valueOf(parts[0]);
                final int numberOfWheels = Integer.parseInt(parts[1]);
                final String brand = parts[2];
                final int yearOfIssue = Integer.parseInt(parts[3]);
                final double maxSpeed = Double.parseDouble((parts[4]));

                final Vehicle note = new Vehicle(type, numberOfWheels, brand, yearOfIssue, maxSpeed);
                System.out.println(note);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
