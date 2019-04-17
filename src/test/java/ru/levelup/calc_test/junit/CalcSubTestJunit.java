package ru.levelup.calc_test.junit;

import org.junit.Before;
import org.junit.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.AssertJUnit.assertEquals;

public class CalcSubTestJunit {

    private Calculator calc;

    @Before
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void subLongTest(){
        long result = calc.sub(4l,2l);
        assertEquals(2l,result);
    }

    @Test
    public void sumDoubleTest(){
        double result = calc.sub(6.0,4.0);
        assertEquals(2.0,result);
    }
}
