package ru.levelup.igor.podvysotsky.qa.homework_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public interface transportPark {

    void printInfo();

    abstract class GasolineVehicle implements transportPark {

        private String brand;
        private String color;
        private int passCapacity;
        private double value;
        private double fuelRate;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String b) {
            brand = b;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String c) {
            color = c;
        }

        public int getPassCapacity() {
            return passCapacity;
        }

        public void setPassCapacity(int pc) {
            passCapacity = pc;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double v) {
            value = v;
        }

        public double getFuelRate() {
            return fuelRate;
        }

        public void setFuelRate(double f) {
            fuelRate = f;
        }
    }


    abstract class ElectricVehicle extends GasolineVehicle {

        private String ecoRate;

        public String getEcoRate() {
            return ecoRate;
        }

        public void setEcoRate(String e) {
            ecoRate = e;

        }
    }

    class Bus extends GasolineVehicle {
        @Override
        public void printInfo() {
            System.out.println("Цена автобуса = " + getValue() + " ; Вместимость = " + getPassCapacity() +
                    " ; Расход топлива = " + getFuelRate() + " ; Цвет = " + getColor() + " ; Марка = " + getBrand());
        }
    }

    class Car extends GasolineVehicle {
        @Override
        public void printInfo() {
            System.out.println("Цена автомобиля = " + getValue() + " ; Вместимость = " + getPassCapacity() +
                    " ; Расход топлива = " + getFuelRate() + " ; Цвет = " + getColor() + " ; Марка = " + getBrand());
        }
    }

    class Trolleybus extends ElectricVehicle {
        @Override
        public void printInfo() {
            System.out.println("Цена троллейбуса = " + getValue() + " ; Вместимость = " + getPassCapacity() +
                    " ; Расход топлива = " + getFuelRate() + " ; Цвет = " + getColor() + " ; Марка = " + getBrand() + " ; Экологичность = " + getEcoRate());
        }
    }

    class Tram extends ElectricVehicle {
        @Override
        public void printInfo() {
            System.out.println("Цена трамвая = " + getValue() + " ; Вместимость = " + getPassCapacity() +
                    " ; Расход топлива = " + getFuelRate() + " ; Цвет = " + getColor() + " ; Марка = " + getBrand() + " ; Экологичность = " + getEcoRate());
        }
    }

    public static void main(String[] args) throws IOException {

        double summ;
        String no = " не найден ";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Bus bus1 = new Bus();
            bus1.setValue(112.0);
            bus1.setPassCapacity(80);
            bus1.setFuelRate(22.5);
            bus1.setColor("Yellow");
            bus1.setBrand("Scania");

        bus1.printInfo();

        Bus bus2 = new Bus();
            bus2.setValue(150.0);
            bus2.setPassCapacity(100);
            bus2.setFuelRate(25.0);
            bus2.setColor("White");
            bus2.setBrand("Man");

        bus2.printInfo();

        Bus bus3 = new Bus();
            bus3.setValue(75.0);
            bus3.setPassCapacity(40);
            bus3.setFuelRate(25.0);
            bus3.setColor("Orange");
            bus3.setBrand("PAZ");

        bus3.printInfo();

        Car car1 = new Car();
            car1.setValue(50.0);
            car1.setPassCapacity(4);
            car1.setFuelRate(8.0);
            car1.setColor("Black");
            car1.setBrand("KIA");

        car1.printInfo();

        Trolleybus tr1 = new Trolleybus();
            tr1.setValue(130.0);
            tr1.setPassCapacity(90);
            tr1.setFuelRate(0.0);
            tr1.setColor("Blue");
            tr1.setBrand("Trollza");
            tr1.setEcoRate("100 %");

        tr1.printInfo();

        Tram tram1 = new Tram();
            tram1.setValue(170.0);
            tram1.setPassCapacity(110);
            tram1.setFuelRate(0.0);
            tram1.setColor("Red");
            tram1.setBrand("RVR");
            tram1.setEcoRate("95 %");

        tram1.printInfo();

        System.out.println("");

        summ = (bus1.getValue() + bus2.getValue() + bus3.getValue() + car1.getValue() + tr1.getValue() + tram1.getValue());
        System.out.println("Общая стоимость транспортных средств = " + summ);

        List<Double> fuelSort = new ArrayList();
        fuelSort.add(bus1.getFuelRate());
        fuelSort.add(bus2.getFuelRate());
        fuelSort.add(bus3.getFuelRate());
        fuelSort.add(car1.getFuelRate());

        Collections.sort(fuelSort);

        System.out.println("");
        System.out.println("Сортировка машин по расходу топлива: " + fuelSort);
        System.out.println("");

        System.out.println("Пожалуйста введите максимальную вместимость автобуса: 40, 80 либо 100 (человек) ");

            int passNumber = Integer.parseInt(reader.readLine());

        System.out.println("");
        System.out.println("Пожалуйста введите средний расход топлива автобуса: 22.5 либо 25.0 (л/100км) ");

            double Frate = Double.parseDouble(reader.readLine());

        System.out.println("");
        System.out.print("Необходимый вам автобус из автопарка:  ");

        if (passNumber == 40 && Frate == 25.0) {
            System.out.println(bus3.getBrand());
        }
        else if (passNumber == 80 && Frate == 22.5) {
            System.out.println(bus1.getBrand());
        }
        else if (passNumber == 100 && Frate == 25.0) {
            System.out.println(bus1.getBrand());
              }
        else {
            System.out.println(no);
         }
    }
}