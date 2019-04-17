package ru.levelup.igor.podvysotsky.qa.homework_1.task_1;

import java.lang.*;
import java.util.Scanner;

public class Calculator {

    int i;
    double j;
    long k;

    double n1;
    double n2;

    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startCalc();
    }

    public void startCalc() {

        System.out.println("Пожалуйста выберите тип вводимых чисел:");
        System.out.println("");
        System.out.println("Тип INT       нажмите  i");
        System.out.println("Тип DOUBLE    нажмите  d");
        System.out.println("Тип LONG      нажмите  l");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();

        // TODO оператор switch больше подходит для данной ситуации чем if-else if-else

        if ("i".equals(type)) {

            // TODO Дублироваие кода
            // TODO Возможно лучше было бы сделать отдельный метод и привести к виду
            //  n1 = someMethod(par);
            //  n2 = someMethod(par);

            System.out.println("Пожалуйста введите число:");
            System.out.println("");
                AddNumber x = new AddNumber();
                n1=x.AddNumber(i);

            System.out.println("Пожалуйста введите второе число:");
            System.out.println("");
                AddNumber y = new AddNumber();
                n2=y.AddNumber(i);
        }
        else if ("d".equals(type)) {

            // TODO Дублироваие кода
            // TODO Возможно лучше было бы сделать отдельный метод и привести к виду
            //  n1 = someMethod(par);
            //  n2 = someMethod(par);

            System.out.println("Пожалуйста введите число:");
            System.out.println("");
                AddNumber x2 = new AddNumber();
                n1 = x2.AddNumber(j);

            System.out.println("Пожалуйста введите второе число:");
            System.out.println("");
                AddNumber y2 = new AddNumber();
                n2 = y2.AddNumber(j);
        }
        else if ("l".equals(type)){

            // TODO Дублироваие кода
            // TODO Возможно лучше было бы сделать отдельный метод и привести к виду
            //  n1 = someMethod(par);
            //  n2 = someMethod(par);

            System.out.println("Пожалуйста введите число:");
            System.out.println("");
                AddNumber x1 = new AddNumber();
                n1 = x1.AddNumber(k);

            System.out.println("Пожалуйста введите второе число:");
            System.out.println("");
                AddNumber y1 = new AddNumber();
                n2 = y1.AddNumber(k);
        }
        System.out.println("Пожалуйста выберите математическую операцию:");
        System.out.println("");
        System.out.println("Для сложения числел                       нажмите  +");
        System.out.println("Для вычитания 2-го числа из 1-го          нажмите  -");
        System.out.println("Для умножения числел                      нажмите  *");
        System.out.println("Для возведения 1-го числа в степень 2-го  нажмите  ^");
        System.out.println("Для вычисления факториала 1-го числа      нажмите  !");
        System.out.println("");

        Scanner scr = new Scanner(System.in);
        String symbol = scr.nextLine();

        // TODO Можно заменить на оператор switch

        if ("+".equals(symbol)) {
            Summ sm = new Summ();
        }
        else if ("-".equals(symbol)) {
            Subtraction su = new Subtraction();
        }
        else if ("*".equals(symbol)) {
            Multiplication mu = new Multiplication();
        }
        else if ("^".equals(symbol)) {
            Power po = new Power();
        }
        else if ("!".equals(symbol)) {
            Factorial fa = new Factorial();
        }
    }
        // TODO Я бы вынес данный класс в отдельный файл

    public class AddNumber {

        public  AddNumber() {
        }
            // TODO Java Code Convention methods naming
            // TODO В каких целях используется передача параметра?

        public int AddNumber(int i) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
                 return n;
        }
        // TODO Java Code Convention methods naming
        // TODO В каких целях используется передача параметра?

        public double AddNumber(double j) {
            Scanner sc = new Scanner(System.in);
            double n = sc.nextDouble();
                 return n;
        }

        public long AddNumber(long k) {
            Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
                 return n;
        }
    }

    // TODO Я бы вынес данный класс в отдельный файл

    public class Summ {

        // TODO Не очень хорошая идея производить вычесления прямо в конструкторе

        public Summ() {
            double sum = (n1 + n2);
            System.out.println("Результат --> " + sum);
        }
        // TODO А где методы на int и long???
    }
    // TODO Я бы вынес данный класс в отдельный файл

    public class Subtraction {

        // TODO Не очень хорошая идея производить вычесления прямо в конструкторе

        public Subtraction() {
            double sub = (n1 - n2);
            System.out.println("Результат --> " + sub);
        }
    }

    // TODO Я бы вынес данный класс в отдельный файл
    public class Multiplication {

        // TODO Не очень хорошая идея производить вычесления прямо в конструкторе

        public Multiplication() {
            double mul = (n1 * n2);
            System.out.println("Результат --> " + mul);
        }
        // TODO А где методы на int и long???
    }

    // TODO Я бы вынес данный класс в отдельный файл
    public class Power {
        // TODO Не очень хорошая идея производить вычесления прямо в конструкторе
        public Power() {
            double a = n1;
            for (int i = 1; i < n2; i++) {
                a *= n1;
                double pow = a;
            }
            System.out.println("Результат --> " + a);
        }
    }

    // TODO Я бы вынес данный класс в отдельный файл
    public class Factorial {

        public Factorial() {
            // TODO Не очень хорошая идея производить вычесления прямо в конструкторе
            if (n1 == 0) {
                // TODO Можно было бы использовать n1++
                System.out.println(n1+=1);
            } else {
                int result = 1;
                for (int i = 1; i <= n1; i++) {
                    result *= i;
                }
                System.out.println("Результат --> " + result);
            }
        }
    }
}


