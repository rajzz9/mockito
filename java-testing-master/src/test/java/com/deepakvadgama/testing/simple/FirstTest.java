package com.deepakvadgama.testing.simple;

import org.junit.Assert;
import org.junit.Test;

public class FirstTest {

    @Test
    public void testTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void failedTest() {
        Assert.assertTrue(false);
        Assert.assertTrue("This test failed.. ", false);
    }

    @Test
    public void otherAsserts() {
        Assert.assertFalse(false);
        Assert.assertEquals(5, 2 + 3);
        Assert.assertEquals("One string", "One " + "string");
        Assert.assertArrayEquals(new int[]{1, 3, 5}, new int[]{1, 3, 5});
    }

}
