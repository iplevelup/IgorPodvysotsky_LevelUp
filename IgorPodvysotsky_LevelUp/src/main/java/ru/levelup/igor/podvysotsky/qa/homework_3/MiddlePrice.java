package ru.levelup.igor.podvysotsky.qa.homework_3;

class MiddlePrice {

    int n ;
    double sum;

    public MiddlePrice() {
        double s = 0.0;
        for (int i = 0; i < n; i++){
            double sum = s + Sku.getPrice();
        }
        double midprice = sum/n;
        System.out.println("Средняя цена --> " + midprice);
    }
}