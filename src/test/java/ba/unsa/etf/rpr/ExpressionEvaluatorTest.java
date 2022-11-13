package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    @Test
    void evaluate1() {
        assertEquals(ExpressionEvaluator.evaluate("( 2.5 + 3 )"), 5.5D);
    }

    @Test
    void evaluate2() {
        assertEquals(3D, ExpressionEvaluator.evaluate("( ( ( 2 + 3 ) * 3 ) - 12 )"));
    }

    @Test
    void evaluate3() {
        assertEquals(13.5D, ExpressionEvaluator.evaluate("( 27 / ( ( ( 2 + 3 ) * 3 ) - 13 ) )"));
    }

    @Test
    void evaluate4() {
        assertEquals(5D, ExpressionEvaluator.evaluate("( sqrt ( ( ( 2 + 3 ) * 3 ) + 10 ) )"));
    }

    @Test
    void evaluate5() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 ^ 3 )"));
    }

    @Test
    void evaluate6() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 + # )"));
    }

    @Test
    void evaluate7() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(2 + 3 )"));
    }

    @Test
    void evaluate8() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(  2 + 3 )"));
    }

    @Test
    void evaluate9() {
        assertEquals(10D, ExpressionEvaluator.evaluate("( ( 2 + 3 ) * ( 4 - 2 ) )"));
    }

}