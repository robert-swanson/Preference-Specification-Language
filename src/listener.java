import generation.PythonGenerator;
import generation.classes.Constraint;
import generation.classes.EvaluatorGenerator;
import generation.classes.RequireableConstraint;
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
    String[] nameList;
    boolean rConstraintPreference = false;
    public static String outputPath;
    boolean plan = true;

    @Override public void enterStart(PSLGrammarParser.StartContext ctx) {
    }

    @Override public void exitStart(PSLGrammarParser.StartContext ctx) throws IOException{
        PythonGenerator.generate(outputPath); // <-- Generation
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

    @Override public void exitPrefer(PSLGrammarParser.PreferContext ctx) { }


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
        // look at the things on the stack made above
    }


    @Override public void enterRConstraint(PSLGrammarParser.RConstraintContext ctx) { }

    @Override public void exitRConstraint(PSLGrammarParser.RConstraintContext ctx) {
        boolean not = false;
        boolean required = true;
        int weight = 0;
        if (ctx.getParent() instanceof PSLGrammarParser.PConstraintContext) {
            PSLGrammarParser.PreferContext pctx = (PSLGrammarParser.PreferContext) ctx.getParent().getParent();
            required = false;

            if (! priorities.containsKey(pctx.NAME().toString())) {
                System.out.println("ERROR: " + pctx.NAME().toString() + " is not a valid Priority");
                System.exit(1);
            } else {
                weight = priorities.get(pctx.NAME().toString());
            }
            if (pctx.NOT() != null) {
                not = true;
            }
        } else {
            PSLGrammarParser.RequireContext rctx = (PSLGrammarParser.RequireContext) ctx.getParent();
            if (rctx.NOT() != null) {
                not = true;
            }
        }
        Constraint constraint;
        if (ctx.NUM() != null) {
            int number = Integer.parseInt(ctx.NUM().toString());
            if (ctx.OF() != null) {
                ArrayList<String> list = new ArrayList<>();
                Collections.addAll(list, nameList);
                if (number > list.size()) {
                    System.out.println("ERROR: the number of required classes exceeds the number in the list");
                    System.exit(1);
                }
                constraint = Constraint.nCourseNames(number, list, not);
            } else if (ctx.UPPER() != null) { //  NUM UPPER DIVISION credit_hours
                constraint = Constraint.greaterThanOrEqualTo(EvaluatorGenerator.totalCreditsGreaterThanEqualToCourseNumber(300),
                        number, 1, not, String.format("%d upper level credits", number));
            } else { //  NUM credit_hours
                constraint = Constraint.greaterThanOrEqualTo(EvaluatorGenerator.totalCredits(), number, 1, not,
                        String.format("%d credits", number));
            }
        } else if (ctx.TAKING() != null) { // TAKING courseNameList BEFORE courseName
            constraint = Constraint.leftBeforeRight(  // only works well with one course in list, maybe loop over children?
                    ctx.courseNameList().getChild(1).toString().replaceAll("(\")", ""),
                    ctx.courseName().getChild(1).toString().replaceAll("\"", ""),
                    not
            );
        } else {
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list, nameList);
            constraint = Constraint.nCourseNames(list.size(), list, not);
        }

        if (required) {
            ((RequireableConstraint) constraint).require();
        } else {
            rConstraintPreference = true;
            constraint.prefer(weight);
        }
    }


    @Override public void enterPConstraint(PSLGrammarParser.PConstraintContext ctx) {
        rConstraintPreference = false;
    }

    @Override public void exitPConstraint(PSLGrammarParser.PConstraintContext ctx) {
        int weight = 0;
        boolean not = false;
        PSLGrammarParser.PreferContext pctx = (PSLGrammarParser.PreferContext) ctx.getParent();

        if (! priorities.containsKey(pctx.NAME().toString())) {
            System.out.println("ERROR: " + pctx.NAME().toString() + " is not a valid Priority");
            System.exit(1);
        } else {
            weight = priorities.get(pctx.NAME().toString());
        }
        if (pctx.NOT() != null) {
            not = true;
        }

        Constraint constraint = null;
        if (ctx.LATER() != null) { // LATER course_classes
            constraint = Constraint.laterClasses(not);
        } else if (ctx.EARLIER() != null) { // EARLIER course_classes
            constraint = Constraint.earlierClasses(not);
        } else if (ctx.MORE_() != null) {
            if (ctx.course_classes() != null) {
                if (plan) {
                    constraint = Constraint.greaterThanOrEqualTo(
                            EvaluatorGenerator.totalCourses(), 45, 16, not, "at least 45 courses"
                    );
                } else {
                    constraint = Constraint.greaterThanOrEqualTo(
                            EvaluatorGenerator.totalCourses(), 6, 2, not, "at least 6 courses"
                    );
                }
            } else {
                if (plan) {
                    constraint = Constraint.greaterThanOrEqualTo(
                            EvaluatorGenerator.totalCredits(), 145, 16, not, "at least 145 credits"
                    );
                } else {
                    constraint = Constraint.greaterThanOrEqualTo(
                            EvaluatorGenerator.totalCredits(), 15, 2, not, "at least 15 credits"
                    );
                }

            }
        } else if (ctx.LESS() != null) {
            if (ctx.course_classes() != null) {
                if (plan) {
                    constraint = Constraint.lessThanOrEqualTo(
                            EvaluatorGenerator.totalCourses(), 44, 16, not, "at most 44 courses"
                    );
                } else {
                    constraint = Constraint.lessThanOrEqualTo(
                            EvaluatorGenerator.totalCourses(), 5, 2, not, "at most 5 courses"
                    );
                }
            } else {
                if (plan) {
                    constraint = Constraint.lessThanOrEqualTo(
                            EvaluatorGenerator.totalCredits(), 144, 16, not, "at most 144 credits"
                    );
                } else {
                    constraint = Constraint.lessThanOrEqualTo(
                            EvaluatorGenerator.totalCredits(), 14, 2, not, "at most 14 credits"
                    );
                }

            }
        }
        if (! rConstraintPreference) {
            constraint.prefer(weight);
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


    @Override public void enterSemester_plan(PSLGrammarParser.Semester_planContext ctx) { }

    @Override public void exitSemester_plan(PSLGrammarParser.Semester_planContext ctx) {
        if (ctx.getText() == "plan") {
            plan = true;
        } else {
            plan = false;
        }
    }


    @Override public void enterEveryRule(ParserRuleContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }


    @Override public void visitTerminal(TerminalNode node) { }

    @Override public void visitErrorNode(ErrorNode node) { }


    static public void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName(args[0]);
        listener.outputPath = args[1];

        PSLGrammarLexer lexer = new PSLGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PSLGrammarParser parser = new PSLGrammarParser(tokens);

        listener myListener = new listener();
        parser.addParseListener(myListener);

        parser.start();
    }
}