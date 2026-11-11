package dz.univ.calculatrice;

public final class SubtractOperation implements Operation {

    @Override
    public double calculate(final double firstNumber, final double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public String symbol() {
        return "-";
    }
}
