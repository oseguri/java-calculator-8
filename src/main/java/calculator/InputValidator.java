package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    public final static String defaultSeparator = ",;";
    public final static String defaultReg = "(^//\\D\\\\n)?((\\d+)[%s]?)*";

    public static boolean validate(String input) {
        String separators = checkCustomSeparator(input);

        // 커스텀 구분자를 포함한 전체 입력 패턴 ex) "//!\n1;2!3", "", "1;2;3,4" ....
        String validateReg = String.format(defaultReg, separators);
        if(!Pattern.matches(validateReg, input)) throw new IllegalArgumentException();
        else return true;
    }

    public static String checkCustomSeparator(String input) {

        // 커스텀 구분자 ex) <//!\n> <//@\n>
        Pattern separatorPattern = Pattern.compile("^//(\\D)\\\\n");

        Matcher matcher = separatorPattern.matcher(input);

        if(matcher.find()) {
            String separator = matcher.group(1);
            if(!defaultSeparator.contains(separator)) return defaultSeparator.concat(separator);
        }
        return ",;";
    }

}

