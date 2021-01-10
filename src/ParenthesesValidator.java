import java.util.HashMap;
import java.util.Map;

public class ParenthesesValidator {

    class Stack{

        private final char[] elements;
        private int size;
        private int top;

        public Stack(int size) {
            elements = new char[size];
            this.size = size;
            top = -1;
        }

        public void push(char data){
            if(top == size - 1){
                throw new RuntimeException("Overflow!");
            }
            elements[++top] = data;
        }

        public char pop(){
            if(top == -1){
                throw new RuntimeException("Underflow!");
            }
            return elements[top--];
        }
    }

    public boolean isValid(String expression) {
        getOpenCloseParenthesesMap();
        for (char parentheses : expression.toCharArray()) {

        }
        return false;
    }

    private Map<Character, Character> getOpenCloseParenthesesMap() {
        Map<Character, Character> openCloseParenthesesMap = new HashMap<>();
        openCloseParenthesesMap.put('{', '}');
        openCloseParenthesesMap.put('(', ')');
        openCloseParenthesesMap.put('[', ']');
        return openCloseParenthesesMap;
    }
}
