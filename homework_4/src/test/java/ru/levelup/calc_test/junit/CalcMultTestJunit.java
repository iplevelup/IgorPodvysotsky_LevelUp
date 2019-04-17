package ru.levelup.calc_test.junit;

import org.junit.Before;
import org.junit.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.AssertJUnit.assertEquals;

public class CalcMultTestJunit {

    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void multLongTest(){
        long result = calc.mult(2l,2l);
        assertEquals(4l,result);
    }
    @Test
    public void multDoubleTest(){
        double result = calc.mult(2.0,2.0);
        assertEquals(4.0,result);
    }
}
