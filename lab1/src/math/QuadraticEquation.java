package math;

public class QuadraticEquation {
    // Вложенный класс для вычисления дискриминанта
    private static class DiscriminantCalculator {
        public static double calculate(double a, double b, double c) {
            return b * b - 4 * a * c;
        }
    }

    // Метод для решения квадратного уравнения
    public static void solve(double a, double b, double c) {
        // Вычисление дискриминанта с использованием вложенного класса
        double discriminant = DiscriminantCalculator.calculate(a, b, c);

        System.out.println("Дискриминант: " + discriminant);

        if (discriminant > 0) {
            // Два различных корня
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корень 1: " + root1);
            System.out.println("Корень 2: " + root2);
        } else if (discriminant == 0) {
            // Один корень (кратный)
            double root = -b / (2 * a);
            System.out.println("Корень: " + root);
        } else {
            // Нет действительных корней
            System.out.println("Нет действительных корней");
        }
    }
}
