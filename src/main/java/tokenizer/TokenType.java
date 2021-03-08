package tokenizer;

public enum TokenType {
    LEFT,
    RIGHT,
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    NUMBER;

    public int priority() {
        return switch (this) {
            case LEFT, RIGHT -> 0;
            case DIVIDE, MULTIPLY -> 2;
            default -> 1;
        };
    }
}
