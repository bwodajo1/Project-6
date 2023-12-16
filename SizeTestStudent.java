import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SizeTestStudent {

    @Test
    public void testSizeValues() {
        // Test the values() method of the Size enum
        Size[] sizes = Size.values();
        assertEquals(3, sizes.length);
        assertEquals(Size.SMALL, sizes[0]);
        assertEquals(Size.LARGE, sizes[2]);
    }

}
