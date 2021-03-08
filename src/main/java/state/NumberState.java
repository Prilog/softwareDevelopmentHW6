package state;

import tokenizer.NumberToken;
import tokenizer.Token;
import tokenizer.Tokenizer;

public class NumberState extends State {
    public NumberState(Tokenizer tokenizer) {
        super(tokenizer);
    }

    public Token create() {
        char symbol = tokenizer.currentSymbol();
        StringBuilder number = new StringBuilder();
        while (Character.isDigit(symbol)) {
            number.append(symbol);
            symbol = tokenizer.nextSymbol();
        }
        tokenizer.setState(new StartState(tokenizer));
        return new NumberToken(number.toString());
    }
}
