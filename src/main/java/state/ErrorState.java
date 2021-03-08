package state;

import tokenizer.Token;
import tokenizer.Tokenizer;

public class ErrorState extends State {
    public ErrorState(Tokenizer tokenizer) {
        super(tokenizer);
    }

    public Token create() {
        throw new IllegalStateException();
    }
}
