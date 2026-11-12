package dz.univ.calculatrice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubtractOperationTest {

    private final SubtractOperation operation = new SubtractOperation();

    @Test
    void shouldSubtractPositiveNumbers() {
        assertEquals(9.5, operation.calculate(12.5, 3.0));
    }

    @Test
    void shouldSubtractNegativeNumbers() {
        assertEquals(-2.0, operation.calculate(-5.0, -3.0));
    }

    @Test
    void shouldSubtractMixedNumbers() {
        assertEquals(-5.0, operation.calculate(-1.5, 3.5));
    }

    @Test
    void shouldExposeSubtractionSymbol() {
        assertEquals("-", operation.symbol());
    }
}
