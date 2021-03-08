package tokenizer;

import visitors.TokenVisitor;

public class NumberToken implements Token {
    private final String value;

    public NumberToken(String str) {
        value = str;
    }

    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public TokenType getType() {
        return TokenType.NUMBER;
    }

    public String toTokenString() {
        return "NUMBER(" + value + ")";
    }

    public Long getValue() {
        return Long.parseLong(value);
    }
}
