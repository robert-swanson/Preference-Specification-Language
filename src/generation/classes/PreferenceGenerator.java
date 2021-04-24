package generation.classes;

import generation.PythonGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class PreferenceGenerator {
    private static final boolean diagnostics = true;
    private final String pythonScoring;
    private final String value;
    private final Object[] scoreArgs;

    private PreferenceGenerator(String pythonScoring, String value, Object[] scoreArgs) {
        this.pythonScoring = pythonScoring;
        this.value = value;
        this.scoreArgs = scoreArgs;
    }

    public void add(double weight) {
        ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(scoreArgs));
        list.add(0, Double.toString(weight));
        list.add(0, value);
        String finalPython = String.format(pythonScoring, list.toArray());
        PythonGenerator.getScorePlanGenerator().addLine(finalPython);
    }

    public static PreferenceGenerator scoreBoolean(String value, String preferenceName, boolean invert) {
        return new PreferenceGenerator("scorer.scoreBoolean(%s, %s, '%s', invert=%s)", value, new Object[]{preferenceName, invert ? "True" : "False"});
    }

    public static PreferenceGenerator scoreSigmoid(String value, String preferenceName, SigmoidParameters parameters, boolean invert) {
        return new PreferenceGenerator("scorer.scoreSigmoid(%s, %s, '%s', invert=%s, worstBound=%s, bestBound=%s, lowerQuartile=%s, upperQuartile=%s)", value, new Object[]{preferenceName, invert ? "True" : "False", parameters.worstBound(), parameters.bestBound(), parameters.lowerQuartile(), parameters.upperQuartile()});
    }

    public static PreferenceGenerator scoreOptimum(String value, String preferenceName, OptimumParameters parameters, boolean invert) {
        return new PreferenceGenerator("scorer.scoreOptimum(%s, %s, '%s', %s, invert=%s, worstDeviance=%s, lowerQuartileDeviance=%s, leftWorstDeviance=%s, leftLowerQuartileDeviance=%s, rightWorstDeviance=%s, rightLowerQuartileDeviance=%s)", value, new Object[]{ preferenceName, invert ? "True" : "False", parameters.optimum(), parameters.worstDeviance(), parameters.lowerQuartileDeviance(), parameters.leftWorstDeviance(),  parameters.leftLowerQuartileDeviance(), parameters.rightWorstDeviance(), parameters.rightLowerQuartileDeviance()});
    }

    private static String dts(Double d) {
        return d == null ? "None" : Double.toString(d);
    }


}
