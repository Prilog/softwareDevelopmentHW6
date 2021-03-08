import tokenizer.Token;
import tokenizer.Tokenizer;
import visitors.CalculateVisitor;
import visitors.PrintVisitor;
import visitors.RPNVisitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        String expression = args[0];

        Tokenizer tokenizer = new Tokenizer(expression);
        List<Token> tokenList = tokenizer.parse();
        System.out.println("Original expression: " + new PrintVisitor().process(tokenList));

        List<Token> RPN = new RPNVisitor().parse(tokenList);
        System.out.println("RPN expression: " + new PrintVisitor().process(RPN));

        Long result = new CalculateVisitor().calc(RPN);
        System.out.println("Result: " + result);
    }
}
