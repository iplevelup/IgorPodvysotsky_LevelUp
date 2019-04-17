package ru.levelup.calc_test.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalcSumTestNg {

    private Calculator calc;

    @BeforeMethod
    public void setUp(){
        calc = new Calculator();
    }

    @DataProvider
    public Object [][] doubleSumDataProvider(){
        return new Object[][]{
                {4.0, 4.0, 8.0},
                {5.0, 5.0, 10.0}
        };

    }

    @DataProvider
    public Object [][] longSumDataProvider(){
        return new Object[][]{
                {4, 4, 8},
                {5, 5, 10}
        };

    }

    @Test(dataProvider = "doubleSumDataProvider")
    public void sumDoubleTest(double a, double b, double res){
        assertEquals(res, calc.sum(a,b));

    }
    @Test(dataProvider = "longSumDataProvider")
    public void sumLongTest(long a, long b, long res){
        assertEquals(res, calc.sum(a,b));

    }
}
