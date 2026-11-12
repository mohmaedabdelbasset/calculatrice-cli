package dz.univ.calculatrice;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Main <+|-> <firstNumber> <secondNumber>");
            return;
        }

        final Operation operation;
        if ("+".equals(args[0])) {
            operation = new AddOperation();
        } else if ("-".equals(args[0])) {
            operation = new SubtractOperation();
        } else {
            System.err.println("Unsupported operation: " + args[0]);
            return;
        }

        try {
            final double firstNumber = Double.parseDouble(args[1]);
            final double secondNumber = Double.parseDouble(args[2]);
            final double result = operation.calculate(firstNumber, secondNumber);
            System.out.println(result);
        } catch (NumberFormatException exception) {
            System.err.println("Numbers must be valid decimals.");
        }
    }
}
