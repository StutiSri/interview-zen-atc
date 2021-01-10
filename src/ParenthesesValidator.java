import java.util.HashMap;
import java.util.Map;

class ParenthesesValidator {

    /**
     * Basic Stack class implementation for char elements
     */
    class Stack {

        private final char[] elements;
        private int size;
        private int top;

        /**
         * @param size - The max expected elements in this stack
         */
        Stack(int size) {
            elements = new char[size];
            this.size = size;
            top = -1;
        }

        /**
         * @param data - If the stack is not full, push the elements to the top of the stack
         *             Throw RuntimeException if the stack is full
         */
        void push(char data) {
            if (top == size - 1) {
                throw new RuntimeException("Overflow!");
            }
            elements[++top] = data;
        }

        /**
         *
         * @return - If the stack is not empty return the top element of the stack
         */
        char pop() {
            if (top == -1) {
                throw new RuntimeException("Underflow!");
            }
            return elements[top--];
        }
    }

    /**
     *
     * @param expression - The expression string with parentheses that needs to be validated
     * @return - return true if the expression is valid, else false.
     */
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

    /**
     *
     * @return - A mapping of opening parentheses with its closing counterpart to
     * keep the search for expected closing parentheses in O(1) time
     */
    private Map<Character, Character> getOpenCloseParenthesesMap() {
        Map<Character, Character> openCloseParenthesesMap = new HashMap<>();
        openCloseParenthesesMap.put('{', '}');
        openCloseParenthesesMap.put('(', ')');
        openCloseParenthesesMap.put('[', ']');
        return openCloseParenthesesMap;
    }
}
