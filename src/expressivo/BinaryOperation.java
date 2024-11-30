package expressivo;

/**
 * Immutable representation of a binary operation expression.
 */
public class BinaryOperation implements Expression {
    private final Expression left;
    private final Expression right;
    private final String operator;

    public BinaryOperation(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        BinaryOperation thatOp = (BinaryOperation) that;
        return left.equals(thatOp.left) && right.equals(thatOp.right) && operator.equals(thatOp.operator);
    }

    @Override
    public int hashCode() {
        int result = left.hashCode();
        result = 31 * result + right.hashCode();
        result = 31 * result + operator.hashCode();
        return result;
    }
}
