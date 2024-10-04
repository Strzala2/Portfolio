public class AreaOfTheTriangle {
    // Method to calculate the area of a triangle using the formula with sine
    public static double calculateAreaWithSine(double a, double b, double gamma) {
        return 0.5 * a * b * Math.sin(Math.toRadians(gamma));
    }

    // Method to calculate the area of a triangle using the formula with three sides
    public static double calculateAreaWithHeron(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        // Example usage:
        double a = 5.0;
        double b = 4.0;
        double gamma = 60.0; // in degrees
        double area = calculateAreaWithSine(a, b, gamma);
        System.out.println("The area of the triangle is: " + area);

        double c = 5.0;
        area = calculateAreaWithHeron(a, b, c);
        System.out.println("The area of the triangle is: " + area);
    }
}