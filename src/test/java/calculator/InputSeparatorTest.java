package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InputSeparatorTest {


    @DisplayName("숫자 분리 테스트")
    @Test
    public void separatorTest() {
        List<Integer> list = Arrays.asList(1,223,45,5);
        Assertions.assertAll(
                () -> Assertions.assertEquals(InputSeparator.getSeparatedNums("//!\\n1:223,45!5"), list),
                () -> Assertions.assertTrue(InputSeparator.getSeparatedNums("").isEmpty())
        );
    }

}
