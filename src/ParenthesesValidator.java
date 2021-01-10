import java.util.HashMap;
import java.util.Map;

class ParenthesesValidator {

    class Stack {

        private final char[] elements;
        private int size;
        private int top;

        Stack(int size) {
            elements = new char[size];
            this.size = size;
            top = -1;
        }

        void push(char data) {
            if (top == size - 1) {
                throw new RuntimeException("Overflow!");
            }
            elements[++top] = data;
        }

        char pop() {
            if (top == -1) {
                throw new RuntimeException("Underflow!");
            }
            return elements[top--];
        }
    }

    boolean isValid(String expression) {
        Stack exprStack = new Stack(expression.length());
        Map<Character, Character> openCloseParenthesesMap = getOpenCloseParenthesesMap();
        for (char parentheses : expression.toCharArray()) {
            if (isOpeningParentheses(parentheses)) {
                exprStack.push(parentheses);
            } else {
                char openingParentheses = exprStack.pop();
                if (!isMatchingClosingParentheses(openCloseParenthesesMap, openingParentheses, parentheses)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ParenthesesValidator().isValid("[]"));

        System.out.println(new ParenthesesValidator().isValid("[}"));

        System.out.println(new ParenthesesValidator().isValid("[()(){}]"));

        System.out.println(new ParenthesesValidator().isValid("[{()}{()}]"));

        System.out.println(new ParenthesesValidator().isValid("[(({})]"));

        System.out.println(new ParenthesesValidator().isValid("[({)}]"));

        System.out.println(new ParenthesesValidator().isValid(""));

    }


    private boolean isMatchingClosingParentheses(Map<Character, Character> openCloseParenthesesMap, char openingParentheses, char parentheses) {
        char expectedClosingParentheses = openCloseParenthesesMap.get(openingParentheses);
        return expectedClosingParentheses == parentheses;
    }

    private boolean isOpeningParentheses(char parentheses) {
        return parentheses == '(' || parentheses == '{' || parentheses == '[';
    }

    private Map<Character, Character> getOpenCloseParenthesesMap() {
        Map<Character, Character> openCloseParenthesesMap = new HashMap<>();
        openCloseParenthesesMap.put('{', '}');
        openCloseParenthesesMap.put('(', ')');
        openCloseParenthesesMap.put('[', ']');
        return openCloseParenthesesMap;
    }
}
