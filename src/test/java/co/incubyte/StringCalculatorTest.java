package co.incubyte;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculatorTest {
    @Test
    public void testCalculator() throws Exception {
        Assert.assertEquals(BigInteger.ZERO, StringCalculator.Add("0"));
        Assert.assertEquals(BigInteger.ONE, StringCalculator.Add("1"));
        Assert.assertEquals(new BigInteger("3"), StringCalculator.Add("1,2"));
        Assert.assertEquals(new BigInteger("5050"), StringCalculator.Add(IntStream.rangeClosed(1, 100).boxed().map(Object::toString).collect(Collectors.joining(","))));
        Assert.assertEquals(new BigInteger("6"), StringCalculator.Add("1\n2,3"));
        Assert.assertEquals(new BigInteger("3"), StringCalculator.Add("//;\n1;2"));
    }

    @Test(expected = Exception.class)
    public void negativeCase() throws Exception {
        StringCalculator.Add("-1,1");
        StringCalculator.Add("-1,-2");
    }
}