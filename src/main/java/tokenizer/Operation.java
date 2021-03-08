package tokenizer;

import visitors.TokenVisitor;

public class Operation implements Token {
    TokenType type;

    public Operation(Character operation) {
        switch (operation) {
            case ('+') -> type = TokenType.PLUS;
            case ('-') -> type = TokenType.MINUS;
            case ('*') -> type = TokenType.MULTIPLY;
            case ('/') -> type = TokenType.DIVIDE;
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

    public Long calc(Long a, Long b) {
        return switch (type) {
            case PLUS -> a + b;
            case MINUS -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
            default -> throw new IllegalStateException();
        };
    }
}
