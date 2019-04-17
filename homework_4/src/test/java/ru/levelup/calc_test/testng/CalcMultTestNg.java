package ru.levelup.calc_test.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalcMultTestNg {

    private Calculator calc;

    @BeforeMethod
    public void setUp(){
        calc = new Calculator();
    }

    @DataProvider
    public Object [][] doubleMultDataProvider(){
        return new Object[][]{
                {4.0, 4.0, 16.0},
                {5.0, 5.0, 25.0}
        };

    }

    @DataProvider
    public Object [][] longMultDataProvider(){
        return new Object[][]{
                {4, 4, 16},
                {5, 5, 25}
        };

    }

    @Test(dataProvider = "doubleMultDataProvider")
    public void multDoubleTest(double a, double b, double res){
        assertEquals(res, calc.mult(a,b));

    }
    @Test(dataProvider = "longMultDataProvider")
    public void multLongTest(long a, long b, long res){
        assertEquals(res, calc.mult(a,b));

    }
}
