package co.incubyte;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StringCalculator {
    static BigInteger Add(String numbers) {
        if (numbers.equals("")) {
            return BigInteger.ZERO;
        } else {
            List<BigInteger> integers = Arrays.stream(numbers.split(",")).map(BigInteger::new).collect(Collectors.toList());
            BigInteger sum = BigInteger.ZERO;
            for (BigInteger integer : integers) {
                sum = sum.add(integer);
            }
            return sum;
        }
    }
}