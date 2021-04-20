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
    boolean isRequired = true;
    String[] nameList;

    @Override public void enterStart(PSLGrammarParser.StartContext ctx) { }

    @Override public void exitStart(PSLGrammarParser.StartContext ctx) throws IOException{
        PythonGenerator.generate("test-data/generator/output/generated.py"); // <-- Generation
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


    @Override public void enterRequire(PSLGrammarParser.RequireContext ctx) {
        isRequired = true;
    }

    @Override public void exitRequire(PSLGrammarParser.RequireContext ctx) { }


    @Override public void enterPrefer(PSLGrammarParser.PreferContext ctx) {
        isRequired = false;
    }

    @Override public void exitPrefer(PSLGrammarParser.PreferContext ctx) {
        if (! priorities.containsKey(ctx.NAME().toString())) {
            System.out.println(ctx.NAME().toString() + " is not a valid Priority");
            System.exit(1);
        }
    }


    @Override public void enterIf_(PSLGrammarParser.If_Context ctx) { }

    @Override public void exitIf_(PSLGrammarParser.If_Context ctx) {
        // clear stack seen in condition
    }


    @Override public void enterOtherwiseIf(PSLGrammarParser.OtherwiseIfContext ctx) { }

    @Override public void exitOtherwiseIf(PSLGrammarParser.OtherwiseIfContext ctx) {
        // clear stack seen in condition
    }


    @Override public void enterOtherwise(PSLGrammarParser.OtherwiseContext ctx) { }

    @Override public void exitOtherwise(PSLGrammarParser.OtherwiseContext ctx) { }


    @Override public void enterWhen(PSLGrammarParser.WhenContext ctx) { }

    @Override public void exitWhen(PSLGrammarParser.WhenContext ctx) { }


    @Override public void enterCondition(PSLGrammarParser.ConditionContext ctx) {
        // make a stack that takes in all conditions
    }

    @Override public void exitCondition(PSLGrammarParser.ConditionContext ctx) {
        // look at the things on the stack! made above
    }


    @Override public void enterConstraint(PSLGrammarParser.ConstraintContext ctx) {
        // make a bool flag that says whether the statement is a require or not (thus being a prefer) and call
        // constraint methods from here. If doing this, then the various if's to see which constraint is being used should be done here

        // or determining which constraint can be done here and assigned to a variable, which is then tested in the prefer or required

        // or maybe reach down into children nodes from prefer / require and determine type of constraint from there
    }

    @Override public void exitConstraint(PSLGrammarParser.ConstraintContext ctx) {
        if (isRequired) { // call required things
            if (ctx.NUM() != null) {
                if (ctx.OF() != null) {
//                    NUM OF courseNameList // X of courses
                    System.out.println("num of "+Arrays.toString(nameList));
                } else if (ctx.UPPER() != null) {
//                    NUM UPPER DIVISION credit_hours // upper division hours
                } else {
//                    NUM credit_hours // creditHours
                }
            } else if (ctx.TAKING() != null) {
//                TAKING courseNameList BEFORE courseName // prereqs
            } else if (ctx.LATER() != null) {
//                LATER course_classes
            } else if (ctx.EARLIER() != null) {
//                EARLIER course_classes
            } else if (ctx.MORE_() != null) {
                if (ctx.course_classes() != null) {
                    //courses
                } else {
                    //credits
                }
            } else if (ctx.LESS() != null) {
                if (ctx.course_classes() != null) {
                    //courses
                } else {
                    //credits
                }
            } else if (ctx.NOT() != null) {
                //do something here?
                System.out.print("NOT!");
            } else {
                //coursenamelist
                // call nCourseNames and pass in listLength as N
                System.out.println(Arrays.toString(nameList));
            }
        } else { // call prefer things

        }
    }


    @Override public void enterCourseNameList(PSLGrammarParser.CourseNameListContext ctx) { }

    @Override public void exitCourseNameList(PSLGrammarParser.CourseNameListContext ctx) {
        nameList = ctx.getText().replaceAll("\"", "").split(",");
//        System.out.print(Arrays.toString(nameList));
    }


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

    }
}