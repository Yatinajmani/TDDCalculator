package co.incubyte;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StringCalculator {
    static BigInteger Add(String numbers) {
        int doubleSlash = numbers.indexOf("//");
        Character delimiter = null;
        if (doubleSlash != -1) {
            delimiter = numbers.charAt(doubleSlash + 2);
            numbers = numbers.substring(doubleSlash + 4);
        }
        if (numbers.equals("")) {
            return BigInteger.ZERO;
        } else {
            String regex = (doubleSlash != -1 ? (delimiter + "|") : "") + ",|\n|\n\r";
            List<BigInteger> integers = Arrays.stream(numbers.split(regex)).map(BigInteger::new).collect(Collectors.toList());
            BigInteger sum = BigInteger.ZERO;
            for (BigInteger integer : integers) {
                sum = sum.add(integer);
            }
            return sum;
        }
    }
}