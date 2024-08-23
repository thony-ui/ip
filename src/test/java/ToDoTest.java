
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void testSaveToFileFormat() {
        ToDo todo = new ToDo("Finish homework");
        String expected = "T | 0 | Finish homework";
        assertEquals(expected, todo.saveToFileFormat());
    }

    @Test
    public void testToString() {
        ToDo todo = new ToDo("Finish homework");
        String expected = "[T][ ] Finish homework";
        assertEquals(expected, todo.toString());
    }
}
