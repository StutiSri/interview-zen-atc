import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesValidatorTest {
    @Test
    void test1() {
        String expression = "[]";
        System.out.println(new ParenthesesValidator().isValid(expression));
    }
}