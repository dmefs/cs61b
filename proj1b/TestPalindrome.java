import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindromeZero() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeOne() {
        assertTrue(palindrome.isPalindrome("1"));
    }
    @Test
    public void testIsPalindromeTrue() {
        assertTrue(palindrome.isPalindrome("noon"));
    }

    @Test
    public void testIsPalindromeFalse() {
        assertFalse(palindrome.isPalindrome("horse"));
    }

    @Test
    public void testIsPalindromeOffByOneTrue() {
        assertFalse(palindrome.isPalindrome("horng", new OffByOne()));
    }

    @Test
    public void testIsPalindromeOffByOneFalse() {
        assertFalse(palindrome.isPalindrome("horse", new OffByOne()));
    }

    @Test
    public void testIsPalindromeCCTrue() {
        assertFalse(palindrome.isPalindrome("horng", new OffByOne()));
    }

    @Test
    public void testIsPalindromeCCFalse() {
        assertFalse(palindrome.isPalindrome("horse", new OffByOne()));
    }
}
