package linkedDictionary;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Some tests for LinkedDictionary...
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */
public class LinkedDictionaryTest {

    @Test(expected = NullPointerException.class)
    public void testGetNullPointerException() {
        System.out.println("test: testGetNullPointerException");
        LinkedDictionary dict = new LinkedDictionary();
        dict.get(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementException() {
        System.out.println("test: testGetNoSuchElementException");
        LinkedDictionary dict = new LinkedDictionary();
        dict.get("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testGetNoSuchElementExceptionNonEmpty");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.get("V");
    }

    @Test()
    public void testGetX() {
        System.out.println("test: testGetX");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(1), dict.get("X"));
    }

    @Test()
    public void testGetY() {
        System.out.println("test: testGetY");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(2), dict.get("Y"));
    }

    @Test()
    public void testGetZ() {
        System.out.println("test: testGetZ");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertEquals(new Token(3), dict.get("Z"));
    }

    @Test()
    public void testGetXX() {
        System.out.println("test: testGetXX");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testGetYY() {
        System.out.println("test: testGetYY");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testGetZZ() {
        System.out.println("test: testGetZZ");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNullPointerException() {
        System.out.println("test: testContainsNullPointerException");
        LinkedDictionary dict = new LinkedDictionary();
        dict.contains(null);
    }

    @Test()
    public void testContainsEmpty() {
        System.out.println("test: testContainsEmpty");
        LinkedDictionary dict = new LinkedDictionary();
        Assert.assertFalse(dict.contains("X"));
    }

    @Test()
    public void testContainsNotFound() {
        System.out.println("test: testContainsNoFound");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertFalse(dict.contains("W"));
    }

    @Test()
    public void testContainsX() {
        System.out.println("test: testContainsX");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsY() {
        System.out.println("test: testContainsY");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZ() {
        System.out.println("test: testContainsZ");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test()
    public void testContainsXX() {
        System.out.println("test: testContainsXX");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("X", new Token(4));
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsYY() {
        System.out.println("test: testContainsYY");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Y", new Token(4));
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZZ() {
        System.out.println("test: testContainsZZ");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.put("Z", new Token(4));
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKey() {
        System.out.println("test: testPutNullPointerExceptionKey");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionValue() {
        System.out.println("test: testPutNullPointerExceptionValue");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", null);

    }

    @Test(expected = NullPointerException.class)
    public void testPutNullPointerExceptionKeyValue() {
        System.out.println("test: testPutNullPointerExceptionKeyValue");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put(null, null);
    }

    @Test()
    public void testPutDyncamicArray() {
        System.out.println("test: testPutDyncamicArray");
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
        dict.replace(null, new Token(1));

    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionValue() {
        System.out.println("test: testReplaceNullPointerExceptionValue");
        LinkedDictionary dict = new LinkedDictionary();
        dict.replace("X", null);

    }

    @Test(expected = NullPointerException.class)
    public void testReplaceNullPointerExceptionKeyValue() {
        System.out.println("test: testReplaceNullPointerExceptionKeyValue");
        LinkedDictionary dict = new LinkedDictionary();
        dict.replace(null, null);
    }

    @Test()
    public void testReplaceX() {
        System.out.println("test: testReplaceX");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("X", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("X"));
    }

    @Test()
    public void testReplaceY() {
        System.out.println("test: testReplaceY");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Y", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Y"));
    }

    @Test()
    public void testReplaceZ() {
        System.out.println("test: testReplaceZ");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.replace("Z", new Token(4));
        Assert.assertEquals(new Token(4), dict.get("Z"));
    }

    @Test()
    public void testReplaceXX() {
        System.out.println("test: testReplaceXX");
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
        dict.replace("V", new Token(1));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullPointerException() {
        System.out.println("test: testRemoveNullPointerException");
        LinkedDictionary dict = new LinkedDictionary();
        dict.remove(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementException() {
        System.out.println("test: testRemoveNoSuchElementException");
        LinkedDictionary dict = new LinkedDictionary();
        dict.remove("V");
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNoSuchElementExceptionNonEmpty() {
        System.out.println("test: testRemoveNoSuchElementExceptionNonEmpty");
        LinkedDictionary dict = new LinkedDictionary();
        dict.put("X", new Token(1));
        dict.put("Y", new Token(2));
        dict.put("Z", new Token(3));
        dict.remove("V");
    }

    @Test()
    public void testRemoveX() {
        System.out.println("test: testRemoveX");
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary dict = new LinkedDictionary();
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
        LinkedDictionary d1 = new LinkedDictionary();
        LinkedDictionary d2 = new LinkedDictionary();
        d1.put("X", new Token(1));
        Assert.assertFalse(d2.contains("X"));
    }

}
