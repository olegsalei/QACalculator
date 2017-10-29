package com.bsu.calculator;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorTest
{
    @Test
    public void sumOfSevenAndSix() {
        Double result = Calculator.Calculate("7+6");
        Assert.assertEquals(result,13.0);
    }

    @Test
    public void differenceOfNineAndTwo() {
        Double result = Calculator.Calculate("9-2");
        Assert.assertEquals(result,7.0);
    }

    @Test
    public void differenceOfNineAndTen() {
        Double result = Calculator.Calculate("9-10");
        Assert.assertEquals(result,-1.0);
    }

    @Test
    public void differenceOfSixOTwentyOneAndTwoOFiftyNine() {
        Double result = Calculator.Calculate("6.21-2.59");
        Assert.assertEquals(result,3.62);
    }

    @Test
    public void multiplicationOfSevenAndSix() {
        Double result = Calculator.Calculate("7*6");
        Assert.assertEquals(result,42.0);
    }

    @Test
    public void multiplicationOfSixOTwentyOneAndTwoOFiftyNine() {
        Double result = Calculator.Calculate("6.21*2.59");
        Assert.assertEquals(result,16.0839);
    }

    @Test
    public void divisionTenToFive() {
        Double result = Calculator.Calculate("10/5");
        Assert.assertEquals(result,2.0);
    }

    @Test
    public void divisionTenToSeven() {
        Double result = Calculator.Calculate("10/7");
        Assert.assertEquals(result,1.4285714285714286);
    }

    @Test
    public void threeMultiplyByOPTwoPlusSixCP() {
        Double result = Calculator.Calculate("3*(2+6)");
        Assert.assertEquals(result,24.0);
    }

    @Test
    public void threeMultiplyByOPTwoMinusSixCP() {
        Double result = Calculator.Calculate("3*(2-6)");
        Assert.assertEquals(result,-12.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divisionByZeroException() {
        Double result = Calculator.Calculate("10/0");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void symbolAinTestString() {
        Double result = Calculator.Calculate("2+a-3");
    }
}
