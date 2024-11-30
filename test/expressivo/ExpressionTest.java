package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    // Tests for Constant
    @Test
    public void testConstantEvaluate() {
        Constant constant = new Constant(5.0);
        assertEquals(5.0, constant.evaluate(), 0.001);
    }

    @Test
    public void testConstantToString() {
        Constant constant = new Constant(5.0);
        assertEquals("5.0", constant.toString());
    }

    @Test
    public void testConstantEquality() {
        Constant constant1 = new Constant(5.0);
        Constant constant2 = new Constant(5.0);
        Constant constant3 = new Constant(10.0);
        assertTrue(constant1.equals(constant2));
        assertFalse(constant1.equals(constant3));
    }

    @Test
    public void testConstantHashCode() {
        Constant constant1 = new Constant(5.0);
        Constant constant2 = new Constant(5.0);
        assertEquals(constant1.hashCode(), constant2.hashCode());
    }

    // Tests for Variable
    @Test
    public void testVariableEvaluate() {
        Variable x = new Variable(5.0);
        assertEquals(5.0, x.evaluate(), 0.001);
    }

    @Test
    public void testVariableToString() {
        Variable x = new Variable(5.0);
        assertEquals("5.0", x.toString());
    }

    @Test
    public void testVariableSetValue() {
        Variable x = new Variable(5.0);
        x.setValue(10.0);
        assertEquals(10.0, x.evaluate(), 0.001);
    }

    @Test
    public void testVariableEquality() {
        Variable x = new Variable(5.0);
        Variable y = new Variable(5.0);
        Variable z = new Variable(10.0);
        assertTrue(x.equals(y));
        assertFalse(x.equals(z));
    }

    // Tests for Addition
    @Test
    public void testAdditionEvaluate() {
        Variable x = new Variable(5.0);
        Variable y = new Variable(10.0);
        Addition addition = new Addition(x, y);
        assertEquals(15.0, addition.evaluate(), 0.001);
    }

    @Test
    public void testAdditionToString() {
        Variable x = new Variable(5.0);
        Variable y = new Variable(10.0);
        Addition addition = new Addition(x, y);
        assertEquals("(5.0 + 10.0)", addition.toString());
    }

    @Test
    public void testAdditionEquality() {
        Variable x = new Variable(5.0);
        Variable y = new Variable(10.0);
        Addition addition1 = new Addition(x, y);
        Addition addition2 = new Addition(x, y);
        Addition addition3 = new Addition(y, x);
        assertTrue(addition1.equals(addition2));
        assertFalse(addition1.equals(addition3)); // Order of operands matters
    }

    @Test
    public void testAdditionHashCode() {
        Variable x = new Variable(5.0);
        Variable y = new Variable(10.0);
        Addition addition1 = new Addition(x, y);
        Addition addition2 = new Addition(x, y);
        assertEquals(addition1.hashCode(), addition2.hashCode());
    }

    // Tests for Multiplication
    @Test
    public void testMultiplicationEvaluate() {
        Variable x = new Variable(5.0);
        Constant two = new Constant(2.0);
        Multiplication multiplication = new Multiplication(x, two);
        assertEquals(10.0, multiplication.evaluate(), 0.001);
    }

    @Test
    public void testMultiplicationToString() {
        Variable x = new Variable(5.0);
        Constant two = new Constant(2.0);
        Multiplication multiplication = new Multiplication(x, two);
        assertEquals("(5.0 * 2.0)", multiplication.toString());
    }

    @Test
    public void testMultiplicationEquality() {
        Variable x = new Variable(5.0);
        Constant two = new Constant(2.0);
        Multiplication mul1 = new Multiplication(x, two);
        Multiplication mul2 = new Multiplication(x, two);
        Variable y = new Variable(10.0);
        Multiplication mul3 = new Multiplication(y, two);
        assertTrue(mul1.equals(mul2));
        assertFalse(mul1.equals(mul3));
    }

    @Test
    public void testMultiplicationHashCode() {
        Variable x = new Variable(5.0);
        Constant two = new Constant(2.0);
        Multiplication mul1 = new Multiplication(x, two);
        Multiplication mul2 = new Multiplication(x, two);
        assertEquals(mul1.hashCode(), mul2.hashCode());
    }
}
