package expressivo;

/**
 * Immutable representation of a constant (number) expression.
 */
public class Constant implements Expression {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Constant thatConst = (Constant) that;
        return Double.compare(thatConst.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
