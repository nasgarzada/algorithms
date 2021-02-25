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
                l1, l2
        ));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean is = true;
        ListNode result = null;
        int carry = 0;
        while (is) {

            boolean isL1Null = l1 == null;
            boolean isL2Null = l2 == null;

            int first = isL1Null ? 0 : l1.val;
            int second = isL2Null ? 0 : l2.val;

            int sum = first + second + carry;

            carry = sum / 10;

            if (sum != 0 || (
                    (!isL1Null && l1.val == 0) || (!isL2Null && l2.val == 0)
            )) {
                result = insertEnd(result, sum % 10);
            }

            if (isL1Null && isL2Null) {
                is = false;
            }
            l1 = isL1Null ? null : l1.next;
            l2 = isL2Null ? null : l2.next;

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