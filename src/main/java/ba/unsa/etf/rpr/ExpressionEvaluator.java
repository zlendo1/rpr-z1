package ba.unsa.etf.rpr;
import java.util.Stack;
import java.util.Vector;

public class ExpressionEvaluator {

    /**
     * @param string String koji pretrazujemo
     * @param pocetni_index Indeks pocetne pozicije pretrage
     * @return Indeks prvog sljedeceg "space" znaka
     */
    private static int nadji_sljedeci_space(String string, int pocetni_index) {
        for (int i = pocetni_index; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                return i;
            }
        }

        return string.length();
    }

    /**
     * @param izraz String koji sadrzi izraz
     * @return Rezultat aritmetickog izraza
     * @throws RuntimeException U slucaju da postoji greska u izrazu
     */
    public static Double evaluate(String izraz) throws RuntimeException {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals   = new Stack<>();

        for (int i = 0; i < izraz.length(); ++i) {
            if (izraz.charAt(i) == ' ') {
                if (i % 2 == 0) {
                    throw new RuntimeException("Greska u argumentu");
                }

                continue;
            }

            int old_i = i;
            String znak = izraz.substring(old_i, i = nadji_sljedeci_space(izraz, old_i));

            if (znak.equals("+"))
                ops.push("+");
            else if (znak.equals("-"))
                ops.push("-");
            else if (znak.equals("*"))
                ops.push("*");
            else if (znak.equals("/"))
                ops.push("/");
            else if (znak.equals("sqrt"))
                ops.push("sqrt");
            else if (znak.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+"))
                    v = v + vals.pop();
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = v * vals.pop();
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);

                vals.push(v);
            }
            else if (!znak.equals("("))
                try {
                    vals.push(Double.parseDouble(znak));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Greska u argumentu");
                }
        }

        return vals.peek();
    }
}
