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

    public static PreferenceGenerator scoreBoolean(String value, String preferenceName) {
        return new PreferenceGenerator("scorer.scoreBoolean(%s, %s, '%s')", value, new Object[]{preferenceName});
    }

//    public static PreferenceGenerator scoreSigmoid(String value, String preferenceName, Double worstBound, Double bestBound, Double lowerQuartile, Double upperQuartile) {
//        return new PreferenceGenerator("scorer.scoreSigmoid(%s, %s, '%s', worstBound=%s, bestBound=%s, lowerQuartile=%s, upperQuartile=%s)", value, new Object[]{preferenceName, dts(worstBound), dts(bestBound), dts(lowerQuartile), dts(upperQuartile)});
//    }
    public static PreferenceGenerator scoreSigmoid(String value, String preferenceName, SigmoidParameters parameters) {
        return new PreferenceGenerator("scorer.scoreSigmoid(%s, %s, '%s', worstBound=%s, bestBound=%s, lowerQuartile=%s, upperQuartile=%s)", value, new Object[]{preferenceName, parameters.worstBound(), parameters.bestBound(), parameters.lowerQuartile(), parameters.upperQuartile()});
    }

//    public static PreferenceGenerator scoreOptimum(String value, String preferenceName, String optimum, Double worstDeviance, Double lowerQuartileDeviance, Double leftWorstDeviance, Double leftLowerQuartileDeviance, Double rightWorstDeviance, Double rightLowerQuartileDeviance ) {
//        return new PreferenceGenerator("scorer.scoreOptimum(%s, %s, '%s', %s, worstDeviance=%s, lowerQuartileDeviance=%s, leftWorstDeviance=%s, leftLowerQuartileDeviance=%s, rightWorstDeviance=%s, rightLowerQuartileDeviance=%s)", value, new Object[]{preferenceName, optimum, dts(worstDeviance), dts(lowerQuartileDeviance), dts(leftWorstDeviance), dts(leftLowerQuartileDeviance), dts(rightWorstDeviance), dts(rightLowerQuartileDeviance)});
//    }

    public static PreferenceGenerator scoreOptimum(String value, String preferenceName, OptimumParameters parameters) {
        return new PreferenceGenerator("scorer.scoreOptimum(%s, %s, '%s', %s, worstDeviance=%s, lowerQuartileDeviance=%s, leftWorstDeviance=%s, leftLowerQuartileDeviance=%s, rightWorstDeviance=%s, rightLowerQuartileDeviance=%s)", value, new Object[]{preferenceName, parameters.optimum(), parameters.worstDeviance(), parameters.lowerQuartileDeviance(), parameters.leftWorstDeviance(),  parameters.leftLowerQuartileDeviance(), parameters.rightWorstDeviance(), parameters.rightLowerQuartileDeviance()});
    }

    private static String dts(Double d) {
        return d == null ? "None" : Double.toString(d);
    }


}
