package visitors;

import tokenizer.*;

import java.util.List;
import java.util.Stack;

public class RPNVisitor implements TokenVisitor {
    private final Stack<Token> tokens;
    private final Stack<Token> stack;

    public RPNVisitor() {
        tokens = new Stack<>();
        stack = new Stack<>();
    }

    public List<Token> parse(List<Token> expression) {
        expression.forEach(token -> token.accept(this));

        while (!stack.isEmpty()) {
            Token token = stack.pop();
            this.tokens.push(token);
        }

        return List.copyOf(this.tokens);
    }

    public void visit(NumberToken token) {
        tokens.push(token);
    }

    public void visit(Brace token) {
        if (token.getType() == TokenType.LEFT) {
            stack.push(token);
        } else {
            Token currentToken = stack.pop();
            while (!stack.isEmpty() && currentToken.getType() != TokenType.LEFT) {
                tokens.push(currentToken);
                currentToken = stack.pop();
            }
        }
    }

    public void visit(Operation token) {
        if (!stack.isEmpty()) {
            TokenType currType = token.getType();
            Token currToken = stack.peek();

            while (!stack.isEmpty() && currType.priority() <= currToken.getType().priority()) {
                currToken = stack.pop();
                tokens.push(currToken);

                if (!stack.isEmpty()) {
                    currToken = stack.peek();
                }
            }
        }

        stack.push(token);
    }
}
