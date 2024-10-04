/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

// Główna klasa obliczająca pole trójkąta
class AreaOfTheTriangle {

    // Przesłonięcie metody - obliczenie pola na podstawie podstawy i wysokości
    public double calculateArea(double base, double height) {
        return (base * height) / 2;
    }

    // Przesłonięcie metody - obliczenie pola na podstawie trzech boków (wzór Herona)
    public double calculateArea(double a, double b, double c) {
        // Obliczanie półobwodu
        double semiPerimeter = (a + b + c) / 2;
        // Wzór Herona
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    // Przesłonięcie metody - obliczenie pola na podstawie dwóch boków i kąta między nimi (wzór z sinusami)
    public double calculateArea(double a, double b, double angleInDegrees) {
        // Konwersja kąta z stopni na radiany
        double angleInRadians = Math.toRadians(angleInDegrees);
        // Wzór na pole z sinusami
        return 0.5 * a * b * Math.sin(angleInRadians);
    }
}

// Klasa główna programu
public class Main {
    public static void main(String[] args) {
        AreaOfTheTriangle triangle = new AreaOfTheTriangle();

        // Pole z podstawą i wysokością
        double area1 = triangle.calculateArea(10, 5);
        System.out.println("Pole trójkąta (podstawa i wysokość): " + area1);

        // Pole z trzema bokami (wzór Herona)
        double area2 = triangle.calculateArea(3, 4, 5);
        System.out.println("Pole trójkąta (trzy boki): " + area2);

        // Pole z dwoma bokami i kątem (wzór z sinusami)
        double area3 = triangle.calculateArea(5, 7, 30);
        System.out.println("Pole trójkąta (dwa boki i kąt): " + area3);
    }
}
