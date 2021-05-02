package reversestring;

public class Main {

    public static void main(String[] args) {
        var list = List.of("Hello","It's","me","How","are","you");
        list.print();
    }

    private static void printReverse(char[] word, int left, int right) {
        if (left >= right)
            return;

        var temp = word[left];
        word[left++] = word[right];
        word[right--] = temp;
        printReverse(word, left, right);

    }

    private static void reverseString(char[] s) {
        printReverse(s, 0, s.length - 1);
    }


}
