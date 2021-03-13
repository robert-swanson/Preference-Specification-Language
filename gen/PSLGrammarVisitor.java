// Generated from /Users/elizabethyeiter/Desktop/COS 382/dsl/src/PSLGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PSLGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PSLGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(PSLGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PSLGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PSLGrammarParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PSLGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(PSLGrammarParser.PriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#require}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequire(PSLGrammarParser.RequireContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#prefer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefer(PSLGrammarParser.PreferContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#if_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_(PSLGrammarParser.If_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#elif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif(PSLGrammarParser.ElifContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#else_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_(PSLGrammarParser.Else_Context ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#when}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(PSLGrammarParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(PSLGrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(PSLGrammarParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#courseNameList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCourseNameList(PSLGrammarParser.CourseNameListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#courseName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCourseName(PSLGrammarParser.CourseNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#credit_hours}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCredit_hours(PSLGrammarParser.Credit_hoursContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLGrammarParser#course_classes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCourse_classes(PSLGrammarParser.Course_classesContext ctx);
}