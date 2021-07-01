public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ll = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ll.addLast(word.charAt(i));
        }
        return ll;
    }
    public boolean isPalindrome(String word) {
        if (word.length() == 0) {
            return true;
        }
        Deque<Character> ll = wordToDeque(word);
        for (int i = 0, j = ll.size() - 1; i < j; i++, j--) {
            if (ll.get(i) != ll.get(j)) {
                return false;
            }
        }
        return true;
    }
}
