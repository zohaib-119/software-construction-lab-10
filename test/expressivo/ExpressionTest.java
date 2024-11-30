package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    // Test the toString() method for various types of expressions
    @Test
    public void testToStringConstant() {
        Expression expr = new Constant(5.0);
        assertEquals("5.0", expr.toString());
    }

    @Test
    public void testToStringVariable() {
        Expression expr = new Variable("x");
        assertEquals("x", expr.toString());
    }

    @Test
    public void testToStringBinaryOperation() {
        Expression expr = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        assertEquals("(x + 5.0)", expr.toString());
    }

    @Test
    public void testToStringComplexExpression() {
        Expression expr = new BinaryOperation(
            new BinaryOperation(new Variable("x"), new Constant(3.0), "+"),
            new Variable("y"),
            "*"
        );
        assertEquals("((x + 3.0) * y)", expr.toString());
    }

    // Test the equals() method for structural equality
    @Test
    public void testEqualsConstant() {
        Expression expr1 = new Constant(5.0);
        Expression expr2 = new Constant(5.0);
        assertTrue(expr1.equals(expr2));
    }

    @Test
    public void testEqualsVariable() {
        Expression expr1 = new Variable("x");
        Expression expr2 = new Variable("x");
        assertTrue(expr1.equals(expr2));
    }

    @Test
    public void testEqualsBinaryOperation() {
        Expression expr1 = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        Expression expr2 = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        assertTrue(expr1.equals(expr2));
    }

    @Test
    public void testEqualsDifferentOperators() {
        Expression expr1 = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        Expression expr2 = new BinaryOperation(new Variable("x"), new Constant(5.0), "*");
        assertFalse(expr1.equals(expr2));
    }

    // Test hashCode() for consistent hashing
    @Test
    public void testHashCodeConstant() {
        Expression expr1 = new Constant(5.0);
        Expression expr2 = new Constant(5.0);
        assertEquals(expr1.hashCode(), expr2.hashCode());
    }

    @Test
    public void testHashCodeVariable() {
        Expression expr1 = new Variable("x");
        Expression expr2 = new Variable("x");
        assertEquals(expr1.hashCode(), expr2.hashCode());
    }

    @Test
    public void testHashCodeBinaryOperation() {
        Expression expr1 = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        Expression expr2 = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        assertEquals(expr1.hashCode(), expr2.hashCode());
    }

    @Test
    public void testHashCodeDifferentOperators() {
        Expression expr1 = new BinaryOperation(new Variable("x"), new Constant(5.0), "+");
        Expression expr2 = new BinaryOperation(new Variable("x"), new Constant(5.0), "*");
        assertNotEquals(expr1.hashCode(), expr2.hashCode());
    }
}
