package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

class AppTest {

    /**
     * Test za main, regularno
     */
    @Test
    void main1() {
        String[] argumenti = new String[] {"(", "2", "+", "3", ")"};
        App.main(argumenti);
    }

    /**
     * Test za main, sa greskom
     */
    @Test
    void main2() {
        String[] argumenti = new String[] {"((", "2", "+", "3", ")"};
        App.main(argumenti);
    }

}
