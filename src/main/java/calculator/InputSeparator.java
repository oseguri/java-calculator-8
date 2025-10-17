package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSeparator {

    private final static String defaultReg = "(?:(\\d+)[%s]?)";

    public static List<Integer> getSeparatedNums(String input) {
        List<Integer> numList = new ArrayList<>();
        String reg = String.format(defaultReg, InputValidator.checkCustomSeparator(input));
        Pattern separatorPattern = Pattern.compile(reg);
        Matcher matcher = separatorPattern.matcher(input);

        while(matcher.find()) {
            numList.add(Integer.valueOf(matcher.group(1)));
        }

        return numList;
    }

}
