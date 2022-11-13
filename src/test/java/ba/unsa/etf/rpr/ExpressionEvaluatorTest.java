package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    /**
     * Testira rad za sabiranje (sa racionalnim brojem)
     */
    @Test
    void evaluate1() {
        assertEquals(ExpressionEvaluator.evaluate("( 2.5 + 3 )"), 5.5D);
    }

    /**
     * Testira operatore * i -
     */
    @Test
    void evaluate2() {
        assertEquals(3D, ExpressionEvaluator.evaluate("( ( ( 2 + 3 ) * 3 ) - 12 )"));
    }

    /**
     * Testira operator / i mix drugih operacija
     */
    @Test
    void evaluate3() {
        assertEquals(13.5D, ExpressionEvaluator.evaluate("( 27 / ( ( ( 2 + 3 ) * 3 ) - 13 ) )"));
    }

    /**
     * Testira sqrt funkciju
     */
    @Test
    void evaluate4() {
        assertEquals(5D, ExpressionEvaluator.evaluate("( sqrt ( ( ( 2 + 3 ) * 3 ) + 10 ) )"));
    }

    /**
     * Testira izuzetak za nepostojeci operator
     */
    @Test
    void evaluate5() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 ^ 3 )"));
    }

    /**
     * Testira izuzetak za nepostojeci broj
     */
    @Test
    void evaluate6() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 2 + # )"));
    }

    /**
     * Testira izuzetak za argument bez razmaka gdje treba biti
     */
    @Test
    void evaluate7() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(2 + 3 )"));
    }

    /**
     * Testira izuzetak za argument sa suvisnim razmakom
     */
    @Test
    void evaluate8() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(  2 + 3 )"));
    }

    /**
     * Testira prednost zagrada
     */
    @Test
    void evaluate9() {
        assertEquals(10D, ExpressionEvaluator.evaluate("( ( 2 + 3 ) * ( 4 - 2 ) )"));
    }

}