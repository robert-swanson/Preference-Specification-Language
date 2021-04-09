package generation;

public class ScorePlanGenerator {
    private final StringBuilder scorePlanFunction;
    private int currentIndent;

    public ScorePlanGenerator() {
        scorePlanFunction = new StringBuilder();
        addLine("def scorePlan():");
        currentIndent = 1;
        addLine("scorer = Scorer()");
    }

    public void addLine(String line) {
        scorePlanFunction.append(PythonGenerator.getIndent(currentIndent));
        scorePlanFunction.append(line);
        scorePlanFunction.append("\n");
    }

    public void closeScope() {
        assert currentIndent > 0;
        scorePlanFunction.append("\n");
        currentIndent--;
    }

    public void openScope() {
        currentIndent++;
    }

    public String getPython() {
        return scorePlanFunction.toString();
    }
}
