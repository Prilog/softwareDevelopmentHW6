package state;

import tokenizer.Brace;
import tokenizer.Operation;
import tokenizer.Token;
import tokenizer.Tokenizer;

public class StartState extends State {
    public StartState(Tokenizer tokenizer) {
        super(tokenizer);
    }

    public Token create() {
        char symbol = tokenizer.currentSymbol();
        Token result;
        if (symbol == '(' || symbol == ')') {
            result = new Brace(symbol);
        } else if (symbol == '*' || symbol == '/' || symbol == '+' || symbol == '-') {
            result = new Operation(symbol);
        } else {
            throw new IllegalStateException();
        }
        tokenizer.nextSymbol();
        return result;
    }
}
