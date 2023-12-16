import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DayTestStudent {

    @Test
    public void testDayValues() {
        // Test the values() method of the Day enum
        Day[] days = Day.values();
        assertEquals(7, days.length);
        assertEquals(Day.MONDAY, days[0]);
        assertEquals(Day.SUNDAY, days[6]);
    }

}
