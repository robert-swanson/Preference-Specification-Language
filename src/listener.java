import generation.PythonGenerator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;


public class listener extends PSLGrammarBaseListener {
    Hashtable<String, Integer> priorities = new Hashtable<>();

    @Override public void enterStart(PSLGrammarParser.StartContext ctx) { }

    @Override public void exitStart(PSLGrammarParser.StartContext ctx) throws IOException{

        File output = new File("test-data/generator/output/generated.py");
        output.createNewFile();
        FileWriter writer = new FileWriter(output);
        PythonGenerator.generate(writer); // <-- Generation
        writer.flush();
        writer.close();
//        System.out.print(priorities);

    }


    @Override public void enterBlock(PSLGrammarParser.BlockContext ctx) { }

    @Override public void exitBlock(PSLGrammarParser.BlockContext ctx) { }


    @Override public void enterBody(PSLGrammarParser.BodyContext ctx) { }

    @Override public void exitBody(PSLGrammarParser.BodyContext ctx) { }


    @Override public void enterStatement(PSLGrammarParser.StatementContext ctx) { }

    @Override public void exitStatement(PSLGrammarParser.StatementContext ctx) { }


    @Override public void enterPriority(PSLGrammarParser.PriorityContext ctx) { }

    @Override public void exitPriority(PSLGrammarParser.PriorityContext ctx) {
        priorities.put(ctx.NAME().toString(), Integer.parseInt(ctx.NUM().toString()));
    }


    @Override public void enterRequire(PSLGrammarParser.RequireContext ctx) { }

    @Override public void exitRequire(PSLGrammarParser.RequireContext ctx) { }


    @Override public void enterPrefer(PSLGrammarParser.PreferContext ctx) { }

    @Override public void exitPrefer(PSLGrammarParser.PreferContext ctx) {
        if (! priorities.containsKey(ctx.NAME().toString())) {
            System.out.println(ctx.NAME().toString() + " is not a valid Priority");
            System.exit(1);
        }
    }


    @Override public void enterIf_(PSLGrammarParser.If_Context ctx) { }

    @Override public void exitIf_(PSLGrammarParser.If_Context ctx) { }


    @Override public void enterOtherwiseIf(PSLGrammarParser.OtherwiseIfContext ctx) { }

    @Override public void exitOtherwiseIf(PSLGrammarParser.OtherwiseIfContext ctx) { }


    @Override public void enterOtherwise(PSLGrammarParser.OtherwiseContext ctx) { }

    @Override public void exitOtherwise(PSLGrammarParser.OtherwiseContext ctx) { }


    @Override public void enterWhen(PSLGrammarParser.WhenContext ctx) { }

    @Override public void exitWhen(PSLGrammarParser.WhenContext ctx) { }


    @Override public void enterCondition(PSLGrammarParser.ConditionContext ctx) { }

    @Override public void exitCondition(PSLGrammarParser.ConditionContext ctx) { }


    @Override public void enterConstraint(PSLGrammarParser.ConstraintContext ctx) {
        // make a bool flag that says whether the statement is a require or not (thus being a prefer) and call
        // constraint methods from here. If doing this, then the various if's to see which constraint is being used should be done here

        // or determining which constraint can be done here and assigned to a variable, which is then tested in the prefer or required

        // or maybe reach down into children nodes from prefer / require and determine type of constraint from there
    }

    @Override public void exitConstraint(PSLGrammarParser.ConstraintContext ctx) { }


    @Override public void enterCourseNameList(PSLGrammarParser.CourseNameListContext ctx) { }

    @Override public void exitCourseNameList(PSLGrammarParser.CourseNameListContext ctx) { }


    @Override public void enterCourseName(PSLGrammarParser.CourseNameContext ctx) { }

    @Override public void exitCourseName(PSLGrammarParser.CourseNameContext ctx) { }


    @Override public void enterCredit_hours(PSLGrammarParser.Credit_hoursContext ctx) { }

    @Override public void exitCredit_hours(PSLGrammarParser.Credit_hoursContext ctx) { }


    @Override public void enterCourse_classes(PSLGrammarParser.Course_classesContext ctx) { }

    @Override public void exitCourse_classes(PSLGrammarParser.Course_classesContext ctx) { }


    @Override public void enterEveryRule(ParserRuleContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }


    @Override public void visitTerminal(TerminalNode node) { }

    @Override public void visitErrorNode(ErrorNode node) { }


    static public void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("test-data/generator/input-good/good-integrated.psl");
        PSLGrammarLexer lexer = new PSLGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PSLGrammarParser parser = new PSLGrammarParser(tokens);

        listener myListener = new listener();
        parser.addParseListener(myListener);

        parser.start();

//        try {
//            File output = new File("test-data/generator/output/generated.py");
//            output.createNewFile();
//            FileWriter writer = new FileWriter(output);
//            PythonGenerator.generate(writer); // <-- Generation
//            writer.flush();
//            writer.close();
//            System.out.print(myListener.priorities);
//        } catch (IOException exception){
//
//        }
    }
}