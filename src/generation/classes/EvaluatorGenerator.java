package generation.classes;

import java.util.ArrayList;

public class EvaluatorGenerator {
    public static String courseNameIn(String courseName) {
        return String.format("evaluator.courseName('%s')", courseName);
    }

    public static String nCourseNamesIn(int n, ArrayList<String> courseNames) {
        return String.format("evaluator.nCourseNamesIn(%d, [%s])", n, arrayListToPython(courseNames));
    }

    public static String violatesLeftBeforeRight(String left, String right) {
        return String.format("evaluator.violatesLeftBeforeRight('%s', '%s')", left, right);
    }

    public static String totalCredits() {
        return "evaluator.totalCredits()";
    }

    public static String totalCourses() {
        return "evaluator.totalCourses()";
    }

    public static String totalCreditGreaterThanEqualToCourseNumber(int courseNumber) {
        return String.format("evaluator.totalCreditsGreaterThanEqualToCourseNumber(%d)", courseNumber);
    }

    public static String totalCoursesGreaterThanEqualToCourseNumber(int courseNumber) {
        return String.format("evaluator.totalCoursesGreaterThanEqualToCourseNumber(%d)", courseNumber);
    }

    public static String averageStartTime() {
        return "evaluator.averageStartTime()";
    }


    // Utilities

    private static String minsSinceMidnightToArmyTime(String minsSinceMidnight) {
        return String.format("ut.minsSinceMidnightToArmyTime(%s)", minsSinceMidnight);
    }

    private static String arrayListToPython(ArrayList<String> list) {
        StringBuilder rv = new StringBuilder();
        boolean first = true;
        for (String s: list) {
            if (!first) {
                rv.append(", ");
            }
            rv.append(String.format("'%s'", s));
            first = false;
        }
        return rv.toString();
    }


}
