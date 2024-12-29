import org.junit.Test;
import static org.junit.Assert.*;
public class Minilab3Tester {
    @Test
    public void findAtEvenTestOne() {
        int [] A = {0,1, 2, 3, 4, 5};
        int e = 4;
        assertTrue(Minilab3.findAtEven(A,e));
    }
    @Test
    public void findAtEvenTestTwo() {
        int [] A = {10, 20, 30, 40, 55};
        int e = 20;
        assertFalse(Minilab3.findAtEven(A,e));
    }
    @Test
    public void crossDiagonalsTestOne() {
        int [][] A = {
                {1, 2, 2},
                {4, 5, 6},
                {7, 8, 9}
        };
        int sum = 14;
        assertEquals(Minilab3.crossDiagonals((A)), sum);
    }
    @Test
    public void crossDiagonalsTestTwo() {
        int [][] A = {
                {2, 3, 4},
                {5, 2, 7},
                {1, 8, 9}
        };
        int sum = 7;
        assertEquals(Minilab3.crossDiagonals(A), sum);
    }
    @Test
    public void maxProductTestOne() {
        int [] A = {1,9,3,4,8,6,7,2};
        int maxProduct = 72;
        assertEquals(Minilab3.maxProduct(A), maxProduct);
    }
    @Test
    public void maxProductTestTwo() {
        int[] A = {1, 9, 3, 4, 8, 6, 10, 2};
        int maxProduct = 90;
        assertEquals(Minilab3.maxProduct(A), maxProduct);
    }
    @Test
    public void weirdBubbleTestOne() {
        int[] A = {9,6,7,8};
        int [] expected = {6, 7, 8, 9};
        Minilab3.weirdBubble(A);
       assertArrayEquals(expected, A);
    }
    @Test
    public void weirdBubbleTestTwo() {
        int[] A = {1, 5, 3, 4, 2, 6};
        int [] expected = {1, 2, 3, 4, 5, 6};
        Minilab3.weirdBubble(A);
        assertArrayEquals(expected,A);
    }
}