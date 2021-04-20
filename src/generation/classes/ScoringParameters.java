package generation.classes;

import java.util.Objects;

class SigmoidParameters {
    private Bound lowerBound;
    private Bound upperBound;

    public SigmoidParameters(Bound lowerBound, Bound upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public String worstBound() {
        return (lowerBound instanceof HardBound) ? lowerBound.value.toString() : "None";
    }
    public String bestBound() {
        return (upperBound instanceof HardBound) ? upperBound.value.toString() : "None";
    }
    public String lowerQuartile() {
        return (lowerBound instanceof SoftBound) ? lowerBound.value.toString() : "None";
    }
    public String upperQuartile() {
        return (upperBound instanceof SoftBound) ? upperBound.value.toString() : "None";
    }
}
class OptimumParameters {
    private Bound leftBound;
    private Bound rightBound;
    private Double optimum;

    public OptimumParameters(Double optimum, Bound leftBound, Bound rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.optimum = optimum;

    }

    public OptimumParameters(Double optimum, Bound bounds) {
        this(optimum, bounds, bounds);
    }

    public String optimum() {
        return optimum.toString();
    }

    public String worstDeviance() {
        return (leftBound.equals(rightBound) && leftBound instanceof HardBound) ? leftBound.value.toString() : "None";
    }
    public String lowerQuartileDeviance() {
        return (leftBound.equals(rightBound) && leftBound instanceof HardBound) ? leftBound.value.toString() : "None";
    }
    public String leftWorstDeviance() {
        return (leftBound instanceof HardBound) ? leftBound.value.toString() : "None";
    }
    public String leftLowerQuartileDeviance() {
        return (leftBound instanceof SoftBound) ? leftBound.value.toString() : "None";
    }
    public String rightWorstDeviance() {
        return (rightBound instanceof HardBound) ? rightBound.value.toString() : "None";
    }
    public String rightLowerQuartileDeviance() {
        return (rightBound instanceof SoftBound) ? rightBound.value.toString() : "None";
    }
}
abstract class Bound {
    Double value;
    public enum BoundType { hard, soft };
    BoundType type;

    public Bound(BoundType type, Double value) {
        this.value = value;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Bound) && ((Bound) o).type == this.type && ((Bound) o).value.equals(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
class HardBound extends Bound {
    public HardBound(Double value) {
        super(BoundType.hard, value);
    }
}

class SoftBound extends Bound {
    public SoftBound(Double value) {
        super(BoundType.soft, value);
    }
}
