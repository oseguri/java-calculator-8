package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @DisplayName("커스텀 구분자 추출 테스트")
    @Test
    public void customSeparatorTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(InputValidator.defaultSeparator.concat("!"), InputValidator.checkCustomSeparator("//!\\n"), "! 추가"),
                () -> Assertions.assertEquals(InputValidator.defaultSeparator, InputValidator.checkCustomSeparator("//1\\n"), "정수 제외"),
                () -> Assertions.assertEquals(InputValidator.defaultSeparator, InputValidator.checkCustomSeparator("//,\\n"), "기본 구분자 제외"),
                () -> Assertions.assertEquals(InputValidator.defaultSeparator.concat("@"), InputValidator.checkCustomSeparator("//@\\n//!\\n"), "맨 앞 구분자만 추가")
        );
    }

    @DisplayName("입력값 검증 테스트 : True")
    @ParameterizedTest
    @ValueSource(strings =  {"//!\\n1:2!3,4", "", "1,2:3", "//!\\n12:13!14,15"})
    public void validationTrueTest(String input) {
        System.out.println("input : " + input);
        Assertions.assertTrue(InputValidator.validate(input));
    }

    @DisplayName("입력값 검증 테스트 : False")
    @ParameterizedTest
    @ValueSource(strings =  {"//!\\n1: 2: 3", "//@\\n//!\n1:2!3", "//@\\n1!2:3,4"})
    public void validationFalseTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }
}
