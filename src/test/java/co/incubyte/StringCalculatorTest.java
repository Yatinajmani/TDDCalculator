package co.incubyte;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void testCalculator() {
        Assert.assertEquals(0, StringCalculator.Add("0"));
        Assert.assertEquals(1, StringCalculator.Add("1"));
        Assert.assertEquals(3, StringCalculator.Add("1,2"));
    }
}