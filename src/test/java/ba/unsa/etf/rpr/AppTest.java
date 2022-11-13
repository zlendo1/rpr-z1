package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

public class AppTest {

    /**
     * Test za main, regularno
     */
    @Test
    public void main1() {
        String[] argumenti = new String[] {"(", "2", "+", "3", ")"};
        App.main(argumenti);
    }

    /**
     * Test za main, sa greskom
     */
    @Test
    public void main2() {
        String[] argumenti = new String[] {"((", "2", "+", "3", ")"};
        App.main(argumenti);
    }

}
