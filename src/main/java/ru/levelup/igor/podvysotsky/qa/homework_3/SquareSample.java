package ru.levelup.igor.podvysotsky.qa.homework_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Реализация решения квадратного уравнения
public class SquareSample {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Пожалуйста введите значение a:");
        System.out.println("");
        double a1 = Double.parseDouble(reader.readLine());

        System.out.println("Пожалуйста введите значение b:");
        System.out.println("");
        double b1 = Double.parseDouble(reader.readLine());

        System.out.println("Пожалуйста введите значение c:");
        System.out.println("");
        double c1 = Double.parseDouble(reader.readLine());

        evaluation(a1, b1, c1);
    }

    double discriminantEvaluation(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    static void evaluation(double a, double b, double c) {
        SquareSample ss = new SquareSample();

        double discriminant = ss.discriminantEvaluation(a, b, c);

        if (discriminant > 0.0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(String.format("x1 = %.2f ; x2 = %.2f", x1, x2));
        } else if (discriminant == 0.0) {
            System.out.println(String.format("x1 = x2 = " + "%.2f",(-b / (2 * a))));
        } else {
            System.out.println("Решение не найдено");
        }
    }
}