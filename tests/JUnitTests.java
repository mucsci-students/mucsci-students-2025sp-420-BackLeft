import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import net.jqwik.api.*;

public class MathUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "-1, 5, 4",
        "0, 0, 0",
        "10, -3, 7"
    })
    void testAddNumbers(int a, int b, int expected) {
        assertEquals(expected, MathUtils.add(a, b));
    }


    @Property
    void testAddNumbers(@ForAll int a, @ForAll int b) {
        assertEquals(a + b, MathUtils.add(a, b));
    }
}
