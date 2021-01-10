import org.junit.jupiter.api.Test;

class ParenthesesValidatorTest {
    @Test
    void test1() {
        String expression = "[]";
        boolean valid = new ParenthesesValidator().isValid(expression);
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test2() {
        String expression = "[}";
        boolean valid = new ParenthesesValidator().isValid(expression);
        assert !valid;
        System.out.println(valid);
    }

    @Test
    void test3() {
        String expression = "[()(){}]";
        boolean valid = new ParenthesesValidator().isValid(expression);
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test4() {
        String expression = "[{()}{()}]";
        boolean valid = new ParenthesesValidator().isValid(expression);
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test5() {
        String expression = "[(({})]";
        boolean valid = new ParenthesesValidator().isValid(expression);
        assert !valid;
        System.out.println(valid);
    }

    @Test
    void test6() {
        String expression = "[({)}]";
        boolean valid = new ParenthesesValidator().isValid(expression);
        assert !valid;
        System.out.println(valid);
    }
}