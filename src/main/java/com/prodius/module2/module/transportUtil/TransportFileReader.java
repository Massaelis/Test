package com.prodius.module2.module.transportUtil;

import com.prodius.module2.module.vehicle.Type;
import com.prodius.module2.module.vehicle.Vehicle;
import com.prodius.module2.module.vehicle.typeVehicle.Bicycle;
import com.prodius.module2.module.vehicle.typeVehicle.Car;
import com.prodius.module2.module.vehicle.typeVehicle.Motorcycle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TransportFileReader {
    private static final String NOTES_FILE = "src/main/resources/vehicle.txt";

    private static final Pattern PATTERN = Pattern.compile("(Type): (\\S+), (Wheels): (\\d+), (Brand): (\\S+)"
            + ", (Year): (\\d+), (Max speed): (\\d+\\.\\d+)");

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
        final InputStream resourceAsStream = TransportFileReader.class.getClassLoader().getResourceAsStream(NOTES_FILE);
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                final List<String> parts = Arrays.stream(line.split(", "))
                        .map(l -> l.split(": "))
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList());

                final Matcher matcher = PATTERN.matcher(line);
                // TODO: 26/04/23 matcher

                final Type type = Type.valueOf(parts.get(1));
                final int numberOfWheels = Integer.parseInt(parts.get(3));
                final String brand = parts.get(5);
                final int yearOfIssue = Integer.parseInt(parts.get(7));
                final double maxSpeed = Double.parseDouble((parts.get(9)));

                switch (type) {
                    case CAR -> System.out.println(new Car(numberOfWheels, brand, yearOfIssue, maxSpeed));
                    case BICYCLE -> System.out.println(new Bicycle(numberOfWheels, brand, yearOfIssue, maxSpeed));
                    case MOTORCYCLE -> System.out.println(new Motorcycle(numberOfWheels, brand, yearOfIssue, maxSpeed));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
