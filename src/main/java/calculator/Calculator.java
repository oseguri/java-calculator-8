package calculator;

import java.util.List;

public class Calculator {

    public static int calculate(String input) {
        InputValidator.validate(input);
        List<Integer> numList = InputSeparator.getSeparatedNums(input);
        return sumByList(numList);
    }

    private static int sumByList(List<Integer> list) {
        int sum = 0;
        for(int n : list) sum += n;
        return sum;
    }

}
