package ru.levelup.calc_test.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalcDivTestNg {

    private Calculator calc;

    @BeforeMethod
    public void setUp(){
        calc = new Calculator();
    }

    @DataProvider
    public Object [][] doubleDivDataProvider(){
        return new Object[][]{
                {20.0, 4.0, 5.0},
                {30.0, 5.0, 6.0}
        };
    }

    @DataProvider
    public Object [][] longDivDataProvider(){
        return new Object[][]{
                {20, 4, 5},
                {30, 5, 6}
        };
    }

    @Test(dataProvider = "doubleDivDataProvider")
    public void divDoubleTest(double a, double b, double res){
        assertEquals(res, calc.div(a,b));

    }
    @Test(dataProvider = "longDivDataProvider")
    public void divLongTest(long a, long b, long res){
        assertEquals(res, calc.div(a,b));

    }
}
