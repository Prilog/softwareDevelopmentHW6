package tokenizer;

import state.ErrorState;
import state.NumberState;
import state.StartState;
import state.State;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final List<Token> tokenList;
    private final String expression;
    private int idx;
    private State state;

    public Tokenizer(String expr) {
        expression = expr + '\0';
        idx = 0;
        state = new StartState(this);
        tokenList = new ArrayList<>();
    }

    public List<Token> parse() {
        while (idx < expression.length()) {
            final char symbol = expression.charAt(idx);
            if (Character.isWhitespace(symbol)) {
                idx++;
                continue;
            } else if (Character.isDigit(symbol)) {
                state = new NumberState(this);
            } else if (symbol == '(' || symbol == ')' || symbol == '*'
                    || symbol == '/' || symbol == '+' || symbol == '-') {
                state = new StartState(this);
            } else if (symbol == '\0') {
                break;
            } else {
                state = new ErrorState(this);
            }
            tokenList.add(state.create());
        }
        return tokenList;
    }

    public void setState(State newState) {
        state = newState;
    }

    public char currentSymbol() {
        assert idx >= expression.length() : new IndexOutOfBoundsException(idx);

        return expression.charAt(idx);
    }

    public char nextSymbol() {
        idx++;
        return currentSymbol();
    }
}
