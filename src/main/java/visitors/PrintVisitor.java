package visitors;

import tokenizer.Brace;
import tokenizer.NumberToken;
import tokenizer.Operation;
import tokenizer.Token;

import java.util.List;

public class PrintVisitor implements TokenVisitor {
    private final StringBuilder result;

    public PrintVisitor() {
        result = new StringBuilder();
    }

    public String process(List<Token> tokens) {
        tokens.forEach(token -> token.accept(this));
        return result.toString();
    }

    public void visit(NumberToken token) {
        addToken(token);
    }

    public void visit(Brace token) {
        addToken(token);
    }

    public void visit(Operation token) {
        addToken(token);
    }

    private void addToken(Token token) {
        result.append(token.toTokenString()).append(" ");
    }
}
