package ba.unsa.etf.rpr;

public class App {
    public static void main(String[] args) {
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < args.length; ++i) {
            if (i != 0) {
                build.append(" ");
            }

            build.append(args[i]);
        }

        String argument = build.toString();

        try {
            System.out.println("Rezultat proslijedjene operacije je: " + ExpressionEvaluator.evaluate(argument));
        } catch (RuntimeException e) {
            System.out.println("Izuzetak: " + e.getMessage());
        }
    }
}
