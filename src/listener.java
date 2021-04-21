import generation.PythonGenerator;
import generation.classes.Constraint;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.util.*;


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


    @Override public void enterRConstraint(PSLGrammarParser.RConstraintContext ctx) { }

    @Override public void exitRConstraint(PSLGrammarParser.RConstraintContext ctx) { }


    @Override public void enterPConstraint(PSLGrammarParser.PConstraintContext ctx) { }

    @Override public void exitPConstraint(PSLGrammarParser.PConstraintContext ctx) { }


//    @Override public void enterConstraint(PSLGrammarParser.ConstraintContext ctx) { }

//    @Override public void exitConstraint(PSLGrammarParser.ConstraintContext ctx) {
//        Constraint constraint;
//        if (isRequired) { // call required things
//            if (ctx.NUM() != null) {
//                if (ctx.OF() != null) { // done
//                    ArrayList<String> list = new ArrayList<>();
//                    Collections.addAll(list, nameList);
//                    if (ctx.NOT() != null) { // find the right thing here
//                        Constraint.nCourseNames(Integer.parseInt(ctx.NUM().toString()), list).require(); //but NOT
//                    } else {
//                        constraint = Constraint.nCourseNames(Integer.parseInt(ctx.NUM().toString()), list);
//                    }
//                    System.out.println("num of "+ Arrays.toString(nameList));
//                } else if (ctx.UPPER() != null) {
////                    NUM UPPER DIVISION credit_hours // upper division hours
//                    if (ctx.NOT() != null) { // find the right thing here
//
//                    } else {
//
//                    }
//                } else {
////                    NUM credit_hours // creditHours
//                    if (ctx.NOT() != null) { // find the right thing here
//
//                    } else {
//
//                    }
//                }
//            } else if (ctx.TAKING() != null) {
////                TAKING courseNameList BEFORE courseName // prereqs
//                if (ctx.NOT() != null) { // find the right thing here
//
//                } else {
//
//                }
//            } else if (ctx.LATER() != null) {
////                LATER course_classes
//                if (ctx.NOT() != null) { // find the right thing here
//
//                } else {
////                    Constraint.laterClasses();
//                }
//            } else if (ctx.EARLIER() != null) {
////                EARLIER course_classes
//                if (ctx.NOT() != null) { // find the right thing here
//
//                } else {
//
//                }
//            } else if (ctx.MORE_() != null) {
//                if (ctx.course_classes() != null) {
//                    //courses
//                    if (ctx.NOT() != null) { // find the right thing here
//
//                    } else {
//
//                    }
//                } else {
//                    //credits
//                    if (ctx.NOT() != null) { // find the right thing here
//
//                    } else {
//
//                    }
//                }
//            } else if (ctx.LESS() != null) {
//                if (ctx.course_classes() != null) {
//                    //courses
//                    if (ctx.NOT() != null) { // find the right thing here
//
//                    } else {
//
//                    }
//                } else {
//                    //credits
//                    if (ctx.NOT() != null) { // find the right thing here
//
//                    } else {
//
//                    }
//                }
//            } else if (ctx.NOT() != null) {
//                //do something here?
//                System.out.print("NOT!");
//            } else { //done
//                ArrayList<String> list = new ArrayList<>();
//                Collections.addAll(list, nameList);
//                if (ctx.NOT() != null) { // find the right thing here
//                    Constraint.nCourseNames(list.size(), list).require(); //but NOT
//                } else {
//                    Constraint.nCourseNames(list.size(), list).require();
//                }
//                System.out.println(Arrays.toString(nameList));
//            }
//        } else { // call prefer things
//
//        }
//
//    }


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


    @Override public void enterSemester_plan(PSLGrammarParser.Semester_planContext ctx) { }

    @Override public void exitSemester_plan(PSLGrammarParser.Semester_planContext ctx) { }


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