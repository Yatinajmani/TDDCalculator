package co.incubyte;

import java.util.Arrays;

public class StringCalculator {
    public static int Add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        } else {
            return Arrays.stream(numbers.split(",")).mapToInt(Integer::valueOf).sum();
        }
    }
}