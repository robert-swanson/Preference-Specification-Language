import org.antlr.v4.runtime.*;

public class Test {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("inputs/good-integrated.psl");
        PSLGrammarLexer lexer = new PSLGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PSLGrammarParser parser = new PSLGrammarParser(tokens);

        parser.start(); // parse the input stream!
    };
}
