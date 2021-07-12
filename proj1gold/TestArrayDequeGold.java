import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> good1 = new ArrayDequeSolution<>();
        String s = new String();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                good1.addLast(i);
                s += "addLast(" + i + ")\n";
            } else {
                sad1.addFirst(i);
                good1.addFirst(i);
                s += "addFirst(" + i + ")\n";
            }
        }
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            Integer expected, actual;

            if (numberBetweenZeroAndOne < 0.5) {
                expected = sad1.removeLast();
                actual = good1.removeLast();
                s += "removeLast()\n";
            } else {
                expected = sad1.removeFirst();
                actual = good1.removeFirst();
                s += "removeFirst()\n";
            }
            assertEquals(s, actual, expected);
        }
        assertEquals(0, sad1.size());
    }
}
