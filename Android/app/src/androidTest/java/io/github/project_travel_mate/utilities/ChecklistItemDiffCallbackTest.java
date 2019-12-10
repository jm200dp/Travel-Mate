package io.github.project_travel_mate.utilities;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import objects.ChecklistItem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChecklistItemDiffCallbackTest {

    @Test
    public void areItemsTheSame() {
        List<ChecklistItem> list1 = new ArrayList<>();
        list1.add(new ChecklistItem("Item1", true, 1));
        list1.add(new ChecklistItem("Item2", true, 2));

        List<ChecklistItem> list2 = new ArrayList<>();
        list2.add(new ChecklistItem("Item1", true, 1));
        list2.add(new ChecklistItem("Item2", true, 2));
        ChecklistItemDiffCallback callback = new ChecklistItemDiffCallback(list1, list2);
        assertTrue(callback.areItemsTheSame(0, 0));
        assertTrue(callback.areItemsTheSame(1, 1));
    }

    @Test
    public void areContentsTheSame() {
        List<ChecklistItem> list1 = new ArrayList<>();
        list1.add(new ChecklistItem("Item1", true, 1));

        List<ChecklistItem> list2 = new ArrayList<>();
        list2.add(new ChecklistItem("Item1", true, 1));
        ChecklistItemDiffCallback callback = new ChecklistItemDiffCallback(list1, list2);
        assertTrue(callback.areContentsTheSame(0, 0));
    }
}