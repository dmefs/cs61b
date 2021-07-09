public class OffByOne implements CharacterComparator {
    public boolean equalChars(char x, char y) {
        if (!(((x >= 65) && (x <= 90)) || ((x >= 97) && (x <= 122)))) {
            return false;
        }
        if (!(((y >= 65) && (y <= 90)) || ((y >= 97) && (y <= 122)))) {
            return false;
        }
        int result = x - y;
        return (result == 1) || (result == -1);
    }
}
