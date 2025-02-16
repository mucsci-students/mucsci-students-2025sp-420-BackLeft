import java.io.File;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.millersville.backleft.UmlClass;
import edu.millersville.backleft.Diagram;
import net.jqwik.api.*;

class DiagramTest {

    @Test
    void testJsonSaveLoad() {
        Diagram diagram = new Diagram("TestUML");
        UmlClass testClass = new UmlClass("Person");
        testClass.addAttribute("name", "String");
        diagram.addClass(testClass);

        String filePath = "diagram.json";
        diagram.saveToJson(filePath);

        Diagram loadedDiagram = Diagram.loadFromJson(filePath);
        assertNotNull(loadedDiagram);
        assertEquals("TestUML", loadedDiagram.toString());

        // Clean up test file
        new File(filePath).delete();
    }

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
