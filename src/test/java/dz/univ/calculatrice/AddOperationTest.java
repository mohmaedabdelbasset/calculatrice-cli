package dz.univ.calculatrice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddOperationTest {

    private final AddOperation operation = new AddOperation();

    @Test
    void shouldAddPositiveNumbers() {
        assertEquals(15.5, operation.calculate(12.5, 3.0));
    }

    @Test
    void shouldAddNegativeNumbers() {
        assertEquals(-8.0, operation.calculate(-5.0, -3.0));
    }

    @Test
    void shouldAddMixedNumbers() {
        assertEquals(2.0, operation.calculate(-1.5, 3.5));
    }

    @Test
    void shouldExposeAdditionSymbol() {
        assertEquals("+", operation.symbol());
    }
}
