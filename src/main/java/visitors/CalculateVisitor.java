package visitors;

import tokenizer.Brace;
import tokenizer.NumberToken;
import tokenizer.Operation;
import tokenizer.Token;

import java.util.List;
import java.util.Stack;

public class CalculateVisitor implements TokenVisitor {
    private final Stack<Long> stack;

    public CalculateVisitor() {
        stack = new Stack<>();
    }

    public long calc(List<Token> tokens) {
        if (tokens.isEmpty()) {
            return 0L;
        }
        tokens.forEach(token -> token.accept(this));
        long result = stack.pop();
        assert !stack.isEmpty() : new RuntimeException();
        return result;
    }

    public void visit(NumberToken token) {
        stack.push(token.getValue());
    }

    public void visit(Brace token) {
        throw new UnsupportedOperationException();
    }

    public void visit(Operation token) {
        assert stack.size() < 2 : new IllegalArgumentException();

        final long b = stack.pop();
        final long a = stack.pop();
        stack.add(token.calc(a, b));
    }
}
