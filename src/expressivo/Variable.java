package expressivo;

/**
 * Immutable representation of a variable expression with a modifiable value.
 */
public class Variable implements Expression {
    private double value;

    public Variable(double initialValue) {
        this.value = initialValue;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Variable variable = (Variable) that;
        return Double.compare(variable.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    /**
     * Evaluates the current value of the variable.
     * 
     * @return the current value of the variable
     */
    @Override
    public double evaluate() {
        return value;
    }

    /**
     * Sets a new value for the variable.
     * 
     * @param newValue the new value to assign to the variable
     */
    public void setValue(double newValue) {
        this.value = newValue;
    }

    /**
     * Retrieves the current value of the variable.
     * 
     * @return the current value of the variable
     */
    public double getValue() {
        return value;
    }
}
