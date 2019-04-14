package ru.levelup.igor.podvysotsky.qa.homework_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeMath.random;


public class Exercise {

    /**
     * 1. Создать класс товара (имя товара; стоимость товара)
     * 2. Написать метод, который возвращает список товаров в заданном диапазоне цен
     * 3. Написать метод, которые возвращает список товаров стоимость, которых больше средней цены + 20
     * 4. Написать метод, которые возвращает имя товара по заданной цене.
     *      Если таких товаров несколько вернуть второй
     *  Требования к данным товаров -
     *  - Имена товаров должны задаваться из преопределенных значений и выбираться случайным образом
     *  - Цена товара задаётся случайным образом
     *  - Длину списка товаров пользователь вводит с клавиатуры
     *  - Для пунктов 2,3,4 задания все значения вводятся пользователем с клавиатуры
     */

    public static void main(String[] args) throws Exception  {
        final List<Sku> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        System.out.println("Введите необходимое количество позиций товара:");
        System.out.println("");
        int n = Integer.parseInt(reader.readLine());

        // TODO Должен быть предопределенный список имён из которого заполняется массив
        for (int i = 0 ; i<n; i++) {
            System.out.println("Введите название товара:");
            System.out.println("");
            String name = reader.readLine();
            System.out.println("Введите ориентировочную цену товара:");
            System.out.println("");
            // double price = Double.parseDouble(reader.readLine());
            //double price = 100*random(Double.parseDouble(reader.readLine()));
                int pr = (int) (100 * random(Integer.parseInt(reader.readLine())));
                double price = (int) pr;
                    list.add(new Sku(name, price));
        }
        System.out.println(list);



        //br = new BufferedReader(new
        //        InputStreamReader(System.in));
        //String str;
        //str = reader.readLine();

        // list.add(new Sku("good 1", 76.98));
        // list.add(new Sku("good 2", 0.95));
        //  list.add(new Sku("good 3", 7.68));
        //  list.add(new Sku("good 4", 56.0));
        //  list.add(new Sku("good 5", 12.98));
        //  list.add(new Sku("good 5", 54.33));
        //  list.add(new Sku("good 6", 4.96));
        //  list.add(new Sku("good 7", 3.14));
        //  list.add(new Sku("good 4", 15.92));
        //  list.add(new Sku("good 2", 17.00));
        //  list.add(new Sku("good 6", 2.0));
        //  list.add(new Sku("good 5", 3.98));
        //  list.add(new Sku("good 1", 76.98));
        //  list.add(new Sku("good 1", 23.98));
        //  list.add(new Sku("good 6", 32.32));
        //  list.add(new Sku("good 3", 76.76));

        System.out.println(getSkuInRange(list, 10, 20));
    }

    static List<Sku> getSkuInRange(List<Sku> inputData, double lowPrice, double highPrice) {
        List<Sku> results = new ArrayList<>();
        for (Sku item : inputData) {
            if(item.getPrice() < highPrice && item.getPrice() > lowPrice) {
                results.add(item);
            }
        }
        return results;
    }

}
// Пример реализации бинарного поиска

  /*  private static int binarySearch(List<Sku> inputData, int searchkey) {

        int low = 0; // lowest index
        int high = List.size - 1; // highest index

        while (low <= high) {
            final int middle = low + (high - low) / 2;
            if (array[middle] == searchkey) {
                return middle;
            } else if (array[middle] < searchkey) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
*/

/*  private static int binarySearch(int[] array, int searchkey) {

        int low = 0; // lowest index
        int high = array.length - 1; // highest index

        while (low <= high) {
            final int middle = low + (high - low) / 2;
            if (array[middle] == searchkey) {
                return middle;
            } else if (array[middle] < searchkey) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
*/