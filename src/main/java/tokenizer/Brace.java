package tokenizer;

import visitors.TokenVisitor;

public class Brace implements Token {
    TokenType type;

    public Brace(Character brace) {
        switch (brace) {
            case ('(') -> type = TokenType.LEFT;
            case (')') -> type = TokenType.RIGHT;
            default -> throw new IllegalArgumentException();
        }
    }

    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public TokenType getType() {
        return type;
    }

    public String toTokenString() {
        return type.toString();
    }
}
