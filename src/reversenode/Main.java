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
        insertEnd(l2, 6);
        insertEnd(l2, 4);


        System.out.println(main.addTwoNumbers(
                new ListNode(0), new ListNode(0)
        ));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean is = true;
        ListNode result = null;
        int carry = 0;
        while (is) {

            int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;

            int sum = first + second + carry;

            carry = sum / 10;

            if (sum != 0 || (
                    (l1 != null && l1.val == 0) || (l2 != null && l2.val == 0)
            )) {
                result = insertEnd(result, sum % 10);
            }

            if (l1 == null && l2 == null) {
                is = false;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }


        return result;
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