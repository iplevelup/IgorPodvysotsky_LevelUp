package ru.levelup.calc_test.junit;

import org.junit.Before;
import org.junit.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.AssertJUnit.assertEquals;

public class CalcSumTestJunit {

    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void sumLongTest(){
        long result = calc.sum(4,4);
        assertEquals(8,result);
    }

    @Test
    public void sumDoubleTest(){
        double result = calc.sum(4.0,4.0);
        assertEquals(8.0,result);
    }
}
