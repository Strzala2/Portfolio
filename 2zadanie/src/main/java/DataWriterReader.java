import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class DataWriterReader {
    public static void writeDataToFile(String filename, double height, double weight, int age) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(String.format("%.0f;%.1f;%d", height, weight, age));
        }
    }

    public static void writeDataToFile(String filename, double height, double weight) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(String.format("%.0f;%.1f;", height, weight));
        }
    }

    public static void writeDataToFile(String filename, double height) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(String.format("%.0f;", height));
        }
    }

    public static void readDataFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] data = line.split(";");
            System.out.println("Wzrost: " + data[0]);
            if (data.length > 1) {
                System.out.println("Waga: " + data[1]);
            } else {
                System.out.println("Waga: nie podano");
            }
            if (data.length > 2) {
                System.out.println("Wiek: " + data[2]);
            } else {
                System.out.println("Wiek: nie podano");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "data.txt";
        writeDataToFile(filename, 168, 60.5, 25);
        readDataFromFile(filename);

        System.out.println();

        writeDataToFile(filename, 170, 65.2);
        readDataFromFile(filename);

        System.out.println();

        writeDataToFile(filename, 172);
        readDataFromFile(filename);
    }
}