package generation;

public class EvaluatorGenerator {
    private final String evaluator = "evaluator";

    public static String courseNameIn(String courseName) {
        return String.format("%s.courseName(%s)", courseName);
    }
}
