import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testEqualCharsTrue() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
    }
    @Test
    public void testEqualCharsFalse() {
        assertFalse(offByN.equalChars('a', 'e'));
        assertFalse(offByN.equalChars('z', 'a'));
        assertFalse(offByN.equalChars('a', 'a'));
    }
}
