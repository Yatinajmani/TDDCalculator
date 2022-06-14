package co.incubyte;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringCalculator {
    static BigInteger Add(String numbers) throws Exception {
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
            String finalNumbers = numbers;
            Supplier<Stream<String>> stream = () -> Arrays.stream(finalNumbers.split(regex));
            BigInteger negative = stream.get().map(BigInteger::new).filter(it -> it.signum() == -1).findFirst().orElse(BigInteger.ZERO);
            if (negative.compareTo(BigInteger.ZERO) > 0)
                throw new Exception("negatives not allowed - " + negative);
            List<BigInteger> integers = stream.get().map(BigInteger::new).collect(Collectors.toList());
            BigInteger sum = BigInteger.ZERO;
            for (BigInteger integer : integers) {
                sum = sum.add(integer);
            }
            return sum;
        }
    }
}