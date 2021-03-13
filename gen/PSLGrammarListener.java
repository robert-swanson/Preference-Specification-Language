// Generated from /Users/elizabethyeiter/Desktop/COS 382/dsl/src/PSLGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PSLGrammarParser}.
 */
public interface PSLGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(PSLGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(PSLGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PSLGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PSLGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(PSLGrammarParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(PSLGrammarParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PSLGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PSLGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#priority}.
	 * @param ctx the parse tree
	 */
	void enterPriority(PSLGrammarParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#priority}.
	 * @param ctx the parse tree
	 */
	void exitPriority(PSLGrammarParser.PriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#require}.
	 * @param ctx the parse tree
	 */
	void enterRequire(PSLGrammarParser.RequireContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#require}.
	 * @param ctx the parse tree
	 */
	void exitRequire(PSLGrammarParser.RequireContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#prefer}.
	 * @param ctx the parse tree
	 */
	void enterPrefer(PSLGrammarParser.PreferContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#prefer}.
	 * @param ctx the parse tree
	 */
	void exitPrefer(PSLGrammarParser.PreferContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterIf_(PSLGrammarParser.If_Context ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitIf_(PSLGrammarParser.If_Context ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#otherwiseIf}.
	 * @param ctx the parse tree
	 */
	void enterOtherwiseIf(PSLGrammarParser.OtherwiseIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#otherwiseIf}.
	 * @param ctx the parse tree
	 */
	void exitOtherwiseIf(PSLGrammarParser.OtherwiseIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#otherwise}.
	 * @param ctx the parse tree
	 */
	void enterOtherwise(PSLGrammarParser.OtherwiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#otherwise}.
	 * @param ctx the parse tree
	 */
	void exitOtherwise(PSLGrammarParser.OtherwiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#when}.
	 * @param ctx the parse tree
	 */
	void enterWhen(PSLGrammarParser.WhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#when}.
	 * @param ctx the parse tree
	 */
	void exitWhen(PSLGrammarParser.WhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PSLGrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PSLGrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(PSLGrammarParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(PSLGrammarParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#courseNameList}.
	 * @param ctx the parse tree
	 */
	void enterCourseNameList(PSLGrammarParser.CourseNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#courseNameList}.
	 * @param ctx the parse tree
	 */
	void exitCourseNameList(PSLGrammarParser.CourseNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#courseName}.
	 * @param ctx the parse tree
	 */
	void enterCourseName(PSLGrammarParser.CourseNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#courseName}.
	 * @param ctx the parse tree
	 */
	void exitCourseName(PSLGrammarParser.CourseNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#credit_hours}.
	 * @param ctx the parse tree
	 */
	void enterCredit_hours(PSLGrammarParser.Credit_hoursContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#credit_hours}.
	 * @param ctx the parse tree
	 */
	void exitCredit_hours(PSLGrammarParser.Credit_hoursContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLGrammarParser#course_classes}.
	 * @param ctx the parse tree
	 */
	void enterCourse_classes(PSLGrammarParser.Course_classesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLGrammarParser#course_classes}.
	 * @param ctx the parse tree
	 */
	void exitCourse_classes(PSLGrammarParser.Course_classesContext ctx);
}