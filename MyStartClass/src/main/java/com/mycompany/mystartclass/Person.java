/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mystartclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author krukm
 */
class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitials() {
        return firstName.charAt(0) + "" + lastName.charAt(0);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class PersonsTools {
    private final Set<String> drawnPeople = new HashSet<>();

    public void displayInitials(List<Person> peopleList) {
        for (Person person : peopleList) {
            System.out.print(person.getInitials() + " ");
        }
        System.out.println();
    }

    public void displayPeople(List<Person> peopleList) {
        System.out.println("Osoby:");
        for (Person person : peopleList) {
            System.out.println(person);
        }
    }

    public void drawPerson(List<Person> peopleList) {
        if (drawnPeople.size() == peopleList.size()) {
            System.out.println("Wszystkie osoby zostały już wylosowane. Rozpoczynam losowanie od nowa.");
            drawnPeople.clear();
        }

        Random random = new Random();
        Person drawnPerson;
        do {
            drawnPerson = peopleList.get(random.nextInt(peopleList.size()));
        } while (drawnPeople.contains(drawnPerson.toString()));

        drawnPeople.add(drawnPerson.toString());
        saveToFile(drawnPerson);
    }

    private void saveToFile(Person person) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("hit.csv", true))) {
            writer.println(person.getFirstName() + "," + person.getLastName());
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku.");
        }
    }
}