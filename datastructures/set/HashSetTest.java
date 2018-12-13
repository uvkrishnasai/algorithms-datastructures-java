package datastructures.set;

import org.junit.Assert;
import org.junit.Test;

public class HashSetTest {

    @Test
    public void testIsEmpty() {
        HashSet set = new HashSet();
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testAddElement() {
        HashSet set = new HashSet();
        Assert.assertTrue(set.add(10));
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void testAddDuplicateElement() {
        HashSet set = new HashSet();
        Assert.assertTrue(set.add(10));
        Assert.assertFalse(set.add(10));
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void testAddElementsMoreThanDefault() {
        HashSet set = new HashSet();
        Assert.assertTrue(set.add(10));
        Assert.assertTrue(set.add(20));
        Assert.assertTrue(set.add(30));
        Assert.assertEquals(3, set.size());
    }

    @Test
    public void testRemove() {
        HashSet set = new HashSet();
        Assert.assertTrue(set.add(10));
        Assert.assertTrue(set.remove(10));
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testRemoveUnknownElement() {
        HashSet set = new HashSet();
        Assert.assertTrue(set.add(10));
        Assert.assertFalse(set.remove(11));
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void testContains() {
        HashSet set = new HashSet();
        Assert.assertTrue(set.add(10));
        Assert.assertTrue(set.contains(10));
        Assert.assertFalse(set.contains(9));
    }

}