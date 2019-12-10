package objects;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChecklistItemTest {

    @Test
    public void equals1() {
        ChecklistItem item1 = new ChecklistItem("Item1", true, 1);
        ChecklistItem item2 = new ChecklistItem("Item2", true, 4);
        ChecklistItem item3 = new ChecklistItem("Item1", true, 4);
        ChecklistItem item4 = new ChecklistItem("Item3", false, 2);

        assertTrue(item1.equals(item1));
        assertTrue(item1.equals(item3));

        assertFalse(item2.equals(item3));
        assertFalse(item3.equals(item4));
    }
}