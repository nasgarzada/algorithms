package reversenode;

import java.math.BigInteger;
import java.util.stream.IntStream;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        var l1 = new ListNode(2);
        insertEnd(l1, 4);
        insertEnd(l1, 3);

        var l2 = new ListNode(5);
        insertEnd(l2, 7);
        insertEnd(l2, 8);
        insertEnd(l2, 9);


        System.out.println(main.addTwoNumbers(
                l1, l2
        ));

        System.out.println(new BigInteger("1000000000000000000000000000000001").add(new BigInteger("564")));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean is = true;
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        while (is) {
            if (l1 != null) {
                b1.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                b2.append(l2.val);
                l2 = l2.next;
            }

            if ((l1 == null && l2 == null)) {
                is = false;
            }
        }

        BigInteger sum = new BigInteger(b1.reverse().toString()).add(new BigInteger(b2.reverse().toString()));

        is = true;
        ListNode root = null;
        while (is) {
            BigInteger temp = sum.remainder(BigInteger.valueOf(10));
            root = insertEnd(root, temp.intValue());
            sum = sum.divide(BigInteger.valueOf(10));
            if (sum.compareTo(BigInteger.valueOf(0)) == 0) {
                is = false;
            }
        }

        return root;
    }

    static ListNode insertEnd(ListNode head, int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            head.next = insertEnd(head.next, data);
        }
        return head;
    }
}