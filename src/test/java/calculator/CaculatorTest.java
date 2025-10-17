package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaculatorTest {
    @Test
    public void caculateTest() {
        Assertions.assertEquals(10, Calculator.calculate("//!\\n1;2!3,4"));
        Assertions.assertEquals(10, Calculator.calculate("//@\\n1@2,3,4"));
        Assertions.assertEquals(10, Calculator.calculate("1;2;3,4"));
        Assertions.assertEquals(0, Calculator.calculate(""));
    }
}
