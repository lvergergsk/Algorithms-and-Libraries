package leetcode.insert_delete_getrandom_0380;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedSetTest {
    RandomizedSet randomizedSet;

    @Before
    public void before() {
        randomizedSet = new RandomizedSet();
    }

    @Test
    public void randomizedSetTest01() {
        assertTrue(randomizedSet.insert(2));
        assertTrue(randomizedSet.insert(4));
        assertTrue(randomizedSet.insert(6));
        assertTrue(randomizedSet.insert(8));
        assertFalse(randomizedSet.insert(2));
        assertTrue(randomizedSet.remove(4));
        assertFalse(randomizedSet.remove(4));
        for (int i = 0; i < 10; i++) randomizedSet.getRandom();
    }

    @Test
    public void randomizedSetTest02() {
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.remove(2));
        assertTrue(randomizedSet.insert(2));
        for (int i = 0; i < 10; i++) randomizedSet.getRandom();
        assertTrue(randomizedSet.remove(1));
        assertFalse(randomizedSet.insert(2));
        for (int i = 0; i < 10; i++) randomizedSet.getRandom();
    }

    @Test
    public void randomizedSetTest03() {
        assertFalse(randomizedSet.remove(0));
        assertFalse(randomizedSet.remove(0));
        assertTrue(randomizedSet.insert(0));
        for (int i = 0; i < 10; i++) randomizedSet.getRandom();
        assertTrue(randomizedSet.remove(0));
        assertTrue(randomizedSet.insert(0));
    }

    @Test
    public void randomizedSetTest04() {
        assertTrue(randomizedSet.insert(3));
        assertFalse(randomizedSet.insert(3));
        for (int i = 0; i < 10; i++) randomizedSet.getRandom();
        assertTrue(randomizedSet.insert(1));
        assertTrue(randomizedSet.remove(3));
        for (int i = 0; i < 10; i++) randomizedSet.getRandom();
        assertTrue(randomizedSet.insert(0));
        assertTrue(randomizedSet.remove(0));
    }

}