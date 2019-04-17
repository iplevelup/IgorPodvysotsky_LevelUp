package ru.levelup.calc_test.junit;

import org.junit.Before;
import org.junit.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.AssertJUnit.assertEquals;

public class CalcDivTestJunit {

    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void divLongTest(){
        long result = calc.div(6l,3l);
        assertEquals(2l,result);
    }
    @Test
    public void divDoubleTest(){
        double result = calc.div(6.0,2.0);
        assertEquals(3.0,result);
    }
}
