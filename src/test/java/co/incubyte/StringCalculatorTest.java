package co.incubyte;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculatorTest {
    @Test
    public void testCalculator() {
        Assert.assertEquals(BigInteger.ZERO, StringCalculator.Add("0"));
        Assert.assertEquals(BigInteger.ONE, StringCalculator.Add("1"));
        Assert.assertEquals(new BigInteger("3"), StringCalculator.Add("1,2"));
        Assert.assertEquals(new BigInteger("5050"), StringCalculator.Add(IntStream.rangeClosed(1, 100).boxed().map(Object::toString).collect(Collectors.joining(","))));
    }
}