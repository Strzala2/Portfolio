/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystartclass;

/**
 *
 * @author krukm
 */
import java.io.*;
import java.util.*;

public class MyStartClass {
    public static void main(String[] args) {
        List<Person> peopleList = new ArrayList<>();
        Menu menu = new Menu(peopleList);
        menu.displayMenu();
        peopleList.add(new Person("Mateusz","Kruk"));
        peopleList.add(new Person("Dorian","Chruszcz"));
        peopleList.add(new Person("Kamil","Biernat"));
        peopleList.add(new Person("Emilia","Katta"));
        peopleList.add(new Person("Krzysztof","Krzywiecki"));
        peopleList.add(new Person("Karol","Korc"));
        peopleList.add(new Person("Dorian","Korc"));
        peopleList.add(new Person("Karol","Chruszcz"));
        peopleList.add(new Person("Eryk","Gruszka"));
        
    }
}

class Menu {
    private final List<Person> peopleList;
    private final PersonsTools personsTools;

    public Menu(List<Person> peopleList) {
        this.peopleList = peopleList;
        this.personsTools = new PersonsTools();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Wyświetl inicjały");
            System.out.println("2. Wyświetl osoby");
            System.out.println("3. Losuj osobę");
            System.out.println("4. Wyjdź z programu");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from input

            switch (choice) {
                case 1 -> personsTools.displayInitials(peopleList);
                case 2 -> personsTools.displayPeople(peopleList);
                case 3 -> personsTools.drawPerson(peopleList);
                case 4 -> {
                    System.out.println("Zamykam program.");
                    System.exit(0);
                }
                default -> System.out.println("Niepoprawny wybór. Wybierz ponownie.");
            }
        }
    }
}