package tokenizer;

import visitors.TokenVisitor;

public interface Token {
    void accept(TokenVisitor visitor);

    TokenType getType();

    String toTokenString();
}
