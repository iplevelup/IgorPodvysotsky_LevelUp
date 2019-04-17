package ru.levelup.calc_test.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class CalcSubTestNg {

    private Calculator calc;

    @BeforeMethod
    public void setUp(){
        calc = new Calculator();
    }

    @DataProvider
    public Object [][] doubleSubDataProvider(){
        return new Object[][]{
                {8.0, 4.0, 4.0},
                {10.0, 5.0, 5.0}
        };
    }

    @DataProvider
    public Object [][] longSubDataProvider(){
        return new Object[][]{
                {8, 4, 4},
                {10, 5, 5}
        };
    }

    @Test(dataProvider = "doubleSubDataProvider")
    public void subDoubleTest(double a, double b, double res){
        assertEquals(res, calc.sub(a,b));

    }

    @Test(dataProvider = "longSubDataProvider")
    public void subDoubleTest(long a, long b, long res){
        assertEquals(res, calc.sub(a,b));

    }
}