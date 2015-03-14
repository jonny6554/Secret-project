package Devoir_3;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Some tests for Dictionary...
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */
public class DictionaryTest {

    @Test(expected = NullPointerException.class)
    public void testGetNullPointerException() {
        System.out.println("test: testGetNullPointerException");
        Dictionary dict = new Dictionary();
        dict.get(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementException() {
        System.out.println("test: testGetNoSuchElementException");
        Dictionary dict = new Dictionary();
        dict.get("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testGetNoSuchElementExceptionNonEmpty");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.get("V");
    }

    @Test()
    public void testGetX() {
        System.out.println("test: testGetX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(1), dict.get("X"));
    }

    @Test()
    public void testGetY() {
        System.out.println("test: testGetY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(2), dict.get("Y"));
    }

    @Test()
    public void testGetZ() {
        System.out.println("test: testGetZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testGetXX() {
        System.out.println("test: testGetXX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testGetYY() {
        System.out.println("test: testGetYY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testGetZZ() {
        System.out.println("test: testGetZZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNullPointerException() {
        System.out.println("test: testContainsNullPointerException");
        Dictionary dict = new Dictionary();
        dict.contains(null);
    }

    @Test()
    public void testContainsEmpty() {
        System.out.println("test: testContainsEmpty");
        Dictionary dict = new Dictionary();
        Assert.assertFalse(dict.contains("X"));
    }

    @Test()
    public void testContainsNotFound() {
        System.out.println("test: testContainsNoFound");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertFalse(dict.contains("W"));
    }

    @Test()
    public void testContainsX() {
        System.out.println("test: testContainsX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsY() {
        System.out.println("test: testContainsY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZ() {
        System.out.println("test: testContainsZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test()
    public void testContainsXX() {
        System.out.println("test: testContainsXX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsYY() {
        System.out.println("test: testContainsYY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZZ() {
        System.out.println("test: testContainsZZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKey() {
        System.out.println("test: testPutNullPointerExceptionKey");
        Dictionary dict = new Dictionary();
        dict.put(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionValue() {
        System.out.println("test: testPutNullPointerExceptionValue");
        Dictionary dict = new Dictionary();
        dict.put("X", null);

    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKeyValue() {
        System.out.println("test: testPutNullPointerExceptionKeyValue");
        Dictionary dict = new Dictionary();
        dict.put(null, null);
    }

    @Test()
    public void testPutDyncamicArray() {
        System.out.println("test: testPutDyncamicArray");
        Dictionary dict = new Dictionary();
        for (int i = 0; i < 1000; i++) {
            dict.put("X" + i, new Token(i));
        }
        for (int i = 0; i < 1000; i++) {
            Assert.assertEquals(new Token(i), dict.get("X" + i));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKey() {
        System.out.println("test: testReplaceNullPointerExceptionKey");
        Dictionary dict = new Dictionary();
        dict.replace(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionValue() {
        System.out.println("test: testReplaceNullPointerExceptionValue");
        Dictionary dict = new Dictionary();
        dict.replace("X", null);

    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKeyValue() {
        System.out.println("test: testReplaceNullPointerExceptionKeyValue");
        Dictionary dict = new Dictionary();
        dict.replace(null, null);
    }

    @Test()
    public void testReplaceX() {
        System.out.println("test: testReplaceX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testReplaceY() {
        System.out.println("test: testReplaceY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testReplaceZ() {
        System.out.println("test: testReplaceZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test()
    public void testReplaceXX() {
        System.out.println("test: testReplaceXX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        dict.replace("X", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("X"));
    }

    @Test()
    public void testReplaceYY() {
        System.out.println("test: testReplaceYY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        dict.replace("Y", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("Y"));
    }

    @Test()
    public void testReplaceZZ() {
        System.out.println("test: testReplaceZZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        dict.replace("Z", new Token(5));
        Assert.assertEquals(new Token(5), dict.get("Z"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testReplaceNoSuchElementException() {
        System.out.println("test: testReplaceNoSuchElementException");
        Dictionary dict = new Dictionary();
        dict.replace("V", new Token(1));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullPointerException() {
        System.out.println("test: testRemoveNullPointerException");
        Dictionary dict = new Dictionary();
        dict.remove(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementException() {
        System.out.println("test: testRemoveNoSuchElementException");
        Dictionary dict = new Dictionary();
        dict.remove("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testRemoveNoSuchElementExceptionNonEmpty");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("V");
    }

    @Test()
    public void testRemoveX() {
        System.out.println("test: testRemoveX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("X");
        Assert.assertFalse(dict.contains("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveY() {
        System.out.println("test: testRemoveY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("Y");
        Assert.assertFalse(dict.contains("Y"));
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveZ() {
        System.out.println("test: testRemoveZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("Z");
        Assert.assertFalse(dict.contains("Z"));
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
    }

    @Test()
    public void testRemoveXX() {
        System.out.println("test: testRemoveXX");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        dict.remove("X");
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveYY() {
        System.out.println("test: testRemoveYY");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        dict.remove("Y");
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testRemoveZZ() {
        System.out.println("test: testRemoveZZ");
        Dictionary dict = new Dictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        dict.remove("Z");
        Assert.assertEquals(new Token(1), dict.get("X"));
        Assert.assertEquals(new Token(2), dict.get("Y"));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testGetStatic() {
        System.out.println("test: testStatic");
        Dictionary d1 = new Dictionary();
        Dictionary d2 = new Dictionary();
        d1.put("X", new Token(1));
        Assert.assertFalse(d2.contains("X"));
    }

}
