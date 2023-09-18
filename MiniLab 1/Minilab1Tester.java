import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Minilab1Tester {
    @Test
    public void isSortedOne() {
        int[] myArray = {1,2,3,4,5};
        assertTrue(Minilab1.isSorted(myArray));
    }
    @Test
    public void isSortedTwo() {
        int[] myArray = {6,7,8,9,10};
        assertTrue(Minilab1.isSorted(myArray));
    }
    @Test
    public void isSortedThree() {
        int[] myArray = {-1,0,1,2,3};
        assertTrue(Minilab1.isSorted(myArray));
    }
    @Test
    public void isSortedFour() {
        int[] myArray = {1,1,1,2,0};
        assertTrue(Minilab1.isSorted(myArray));
    }
    @Test
    public void isSortedFive() {
        int [] myArray = {1,2,2,1,3};
        assertTrue(Minilab1.isSorted(myArray));
    }
    @Test
    public void isRowUniqueOne() {
        int [][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 0;
        assertTrue(Minilab1.isRowUnique(board, n));
    }
    @Test
    public void isRowUniqueTwo() {
        int [][] board = {
                {9, 2, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 0;
        assertFalse(Minilab1.isRowUnique(board, n));
    }
    @Test
    public void isRowUniqueThree () {
        int [][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 1;
        assertTrue(Minilab1.isRowUnique(board, n));
    }
    @Test
    public void isRowUniqueFour() {
        int [][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 3;
        assertTrue(Minilab1.isRowUnique(board, n));
    }
    @Test
    public void isRowUniqueFive() {
        int [][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 6, 6, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 7;
        assertFalse(Minilab1.isRowUnique(board, n));
    }
    @Test
    public void isColUniqueOne() {
        int [][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 0;
        assertTrue(Minilab1.isColUnique(board, n));
    }
    @Test
    public void isColUniqueTwo() {
        int[][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 1, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 1;
        assertFalse(Minilab1.isColUnique(board, n));
    }
    @Test
    public void isColUniqueThree() {
        int[][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 1, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 2;
        assertFalse(Minilab1.isColUnique(board, n));
    }
    @Test
    public void isColUniqueFour() {
        int[][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 3, 1, 4, 9, 7, 8},
                {4, 8, 7, 5, 9, 2, 6, 1, 3}
        };
        int n = 0;
        assertTrue(Minilab1.isColUnique(board, n));
    }
    @Test
    public void isColUniqueFive() {
        int[][] board = {
                {9, 3, 1, 8, 6, 5, 7, 2, 4},
                {8, 6, 4, 1, 2, 7, 3, 9, 5},
                {7, 2, 5, 4, 3, 9, 8, 6, 1},
                {5, 9, 3, 2, 7, 1, 4, 8, 6},
                {1, 4, 6, 9, 5, 8, 2, 3, 7},
                {2, 7, 8, 6, 4, 3, 1, 5, 9},
                {3, 1, 9, 7, 8, 6, 5, 4, 2},
                {6, 5, 2, 2, 1, 4, 9, 7, 8},
                {4, 8, 7, 1, 9, 2, 6, 1, 3}
        };
        int n = 3;
        assertFalse(Minilab1.isColUnique(board, n));
    }
    @Test
    public void concatIfMirroredOne() {
        assertEquals("goddog", Minilab1.concatIfMirrored("god","dog"));
    }
    @Test
    public void concatIfMirroredTwo() {
        assertEquals("hannahhannah", Minilab1.concatIfMirrored("hannah","hannah"));

    }
    @Test
    public void concatIfMirroredThree() {
        assertEquals("tarrat", Minilab1.concatIfMirrored("tar","rat"));

    }
    @Test
    public void concatIfMirroredFour() {
        assertEquals("mommom", Minilab1.concatIfMirrored("mom","mom"));

    }
    @Test
    public void concatIfMirroredFive() {
        assertEquals("daddad", Minilab1.concatIfMirrored("dad","dad"));

    }

    @Test
    public void isRowUniqueBonusOne() {
        int [][] board = {
                {3,5,7},
                {1,2,4},
                {6,8,9}
        };
        int n = 0;
        assertTrue(Minilab1.isRowUniqueBonus(board, n));
    }
    @Test
    public void isRowUniqueBonusTwo() {
        int[][] board = {
                {3, 5, 7, 7},
                {1, 2, 4},
                {6, 8, 9}
        };
        int n = 0;
        assertFalse(Minilab1.isRowUniqueBonus(board, n));
    }
    @Test
    public void isRowUniqueBonusThree() {
        int[][] board = {
                {3, 5, 7, 7},
                {1, 2, 3},
                {6, 8, 9, 0}
        };
        int n = 2;
        assertTrue(Minilab1.isRowUniqueBonus(board, n));
    }
    @Test
    public void isRowUniqueBonusFour() {
        int[][] board = {
                {3, 5, 7, 7},
                {1, 1, 3},
                {6, 8, 9, 0, 7, 1}
        };
        int n = 1;
        assertFalse(Minilab1.isRowUniqueBonus(board, n));
    }
    @Test
    public void isRowUniqueBonusFive() {
        int[][] board = {
                {3, 5, 7, 7},
                {1, 0, 3},
                {6, 6, 9, 7, 7, 1}
        };
        int n = 2;
        assertFalse(Minilab1.isRowUniqueBonus(board, n));
    }
}