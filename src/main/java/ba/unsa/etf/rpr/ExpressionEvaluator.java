package ba.unsa.etf.rpr;
import java.util.Stack;
import java.util.Vector;

public class ExpressionEvaluator {

    private static Stack<String> ops;
    private static Stack<Double> vals;
    private static final RuntimeException e_arg = new RuntimeException("Greska u argumentu");

    /**
     * Koristi se za rastavu stringa na dijelove bez space-a
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
     * Metoda koja prima aritmeticki izraz forme pogodne za Dijkstra algoritam koji izracuava vrijednost izraza
     * @param izraz String koji sadrzi izraz
     * @return Rezultat aritmetickog izraza
     * @throws RuntimeException U slucaju da postoji greska u izrazu
     */
    public static Double evaluate(String izraz) throws RuntimeException {
        ops = new Stack<>();
        vals   = new Stack<>();

        int broj_zagrada = 0;
        int broj_uzastopnih_razmaka = 0;

        for (int i = 0; i < izraz.length();) {
            if (izraz.charAt(i) == ' ') {
                if (broj_uzastopnih_razmaka++ > 0) {
                    throw e_arg;
                }

                ++i;

                continue;
            } else {
                broj_uzastopnih_razmaka = 0;
            }

            int old_i = i;
            String znak = izraz.substring(old_i, i = nadji_sljedeci_space(izraz, old_i));

            if (znak.equals("("))
                broj_zagrada++;
            else if (znak.equals("+"))
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
                broj_zagrada--;

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
            else try {
                vals.push(Double.parseDouble(znak));
            } catch (NumberFormatException e) {
                throw e_arg;
            }
        }

        if (broj_zagrada != 0)
            throw e_arg;

        return vals.peek();
    }
}