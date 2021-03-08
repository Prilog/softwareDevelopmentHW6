package state;

import tokenizer.Token;
import tokenizer.Tokenizer;

public abstract class State {
    protected final Tokenizer tokenizer;

    public State(Tokenizer t) {
        tokenizer = t;
    }

    public abstract Token create();
}
