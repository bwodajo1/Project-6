import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TypeTestStudent {

    @Test
    public void testTypeValues() {
        // Test the values() method of the Type enum
        Type[] types = Type.values();
        assertEquals(3, types.length);
        assertEquals(Type.COFFEE, types[0]);
        assertEquals(Type.SMOOTHIE, types[2]);
    }


